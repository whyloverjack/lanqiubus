package com.jack.lanqiubus.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class FileUtils {
	private static int WINDOWS_RETRY_COUNT = 3;
	
	public static void deleteRecursively(File directory) throws IOException {
		Stack<File> stack = new Stack<File>();
		List<File> temp = new LinkedList<File>();
		stack.push(directory.getAbsoluteFile());
		while (!stack.isEmpty()) {
			File top = stack.pop();
			if (top.listFiles() != null) {
				for (File child : top.listFiles()) {
					if (child.isFile()) {
						if (!deleteFile(child)) {
							throw new IOException("Failed to delete "
									+ child.getCanonicalPath());
						}
					} else {
						temp.add(child);
					}
				}
			}
			if (top.listFiles() == null || top.listFiles().length == 0) {
				if (!deleteFile(top)) {
					throw new IOException("Failed to delete "
							+ top.getCanonicalPath());
				}
			} else {
				stack.push(top);
				for (File f : temp) {
					stack.push(f);
				}
			}
			temp.clear();
		}
	}

	public static boolean deleteFile(File file) {
		if (!file.exists()) {
			return true;
		}
		int count = 0;
		boolean deleted = false;
		do {
			deleted = file.delete();
			if (!deleted) {
				count++;
				waitSome();
			}
		} while (!deleted && count <= WINDOWS_RETRY_COUNT);
		return deleted;
	}

	public static File[] deleteFiles(File directory, String regexPattern)
			throws IOException {
		Pattern pattern = Pattern.compile(regexPattern);
		Collection<File> deletedFiles = new ArrayList<File>();
		for (File file : directory.listFiles()) {
			if (pattern.matcher(file.getName()).find()) {
				if (!file.delete()) {
					throw new IOException("Couldn't delete file '"
							+ file.getAbsolutePath() + "'");
				}
				deletedFiles.add(file);
			}
		}
		return deletedFiles.toArray(new File[deletedFiles.size()]);
	}

	public static void moveFile(File toMove, File target) throws IOException {
//		if (!toMove.exists())
//			throw new NotFoundException("Source file[" + toMove.getName()
//					+ "] not found");
//		if (target.exists())
//			throw new NotFoundException("Target file[" + target.getName()
//					+ "] already exists");

		if (toMove.renameTo(target))
			return;

		if (toMove.isDirectory()) {
			target.mkdirs();
			copyRecursively(toMove, target);
			deleteRecursively(toMove);
		} else {
			copyFile(toMove, target);
			deleteFile(toMove);
		}
	}

	public static File moveFileToDirectory(File toMove, File targetDirectory)
			throws IOException {
		if (!targetDirectory.isDirectory()) {
			throw new IllegalArgumentException(
					"Move target must be a directory, not " + targetDirectory);
		}

		File target = new File(targetDirectory, toMove.getName());
		moveFile(toMove, target);
		return target;
	}

	public static boolean renameFile(File srcFile, File renameToFile) {
//		if (!srcFile.exists()) {
//			throw new NotFoundException("Source file[" + srcFile.getName()
//					+ "] not found");
//		}
//		if (renameToFile.exists()) {
//			throw new NotFoundException("Target file[" + renameToFile.getName()
//					+ "] already exists");
//		}
		int count = 0;
		boolean renamed = false;
		do {
			renamed = srcFile.renameTo(renameToFile);
			if (!renamed) {
				count++;
				waitSome();
			}
		} while (!renamed && count <= WINDOWS_RETRY_COUNT);
		return renamed;
	}

	public static void truncateFile(FileChannel fileChannel, long position)
			throws IOException {
		int count = 0;
		boolean success = false;
		IOException cause = null;
		do {
			count++;
			try {
				fileChannel.truncate(position);
				success = true;
			} catch (IOException e) {
				cause = e;
			}

		} while (!success && count <= WINDOWS_RETRY_COUNT);
		if (!success) {
			throw cause;
		}
	}

	public static void truncateFile(File file, long position)
			throws IOException {
		RandomAccessFile access = new RandomAccessFile(file, "rw");
		try {
			truncateFile(access.getChannel(), position);
		} finally {
			access.close();
		}
	}

	private static void waitSome() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ee) {
			Thread.interrupted();
		} // ok
		System.gc();
	}

	public static String fixSeparatorsInPath(String path) {
		String fileSeparator = System.getProperty("file.separator");
		if ("\\".equals(fileSeparator)) {
			path = path.replace('/', '\\');
		} else if ("/".equals(fileSeparator)) {
			path = path.replace('\\', '/');
		}
		return path;
	}

	public static String extractPath(String path){
		File file = new File(path);
		if(file.exists()){
			return null;
		}
		
		String fileSeparator = System.getProperty("file.separator");
		String filePath = fixSeparatorsInPath(path);
		filePath= filePath.substring(0,filePath.lastIndexOf(fileSeparator));
		file = new File(filePath);
		file.mkdirs();
		return filePath;
	}
	
	public static void copyFile(File srcFile, File dstFile) throws IOException {
		// noinspection ResultOfMethodCallIgnored
		dstFile.getParentFile().mkdirs();
		FileInputStream input = new FileInputStream(srcFile);
		FileOutputStream output = new FileOutputStream(dstFile);
		int bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];
		int bytesRead;
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		input.close();
		output.close();
	}

	public static void copyRecursively(File fromDirectory, File toDirectory)
			throws IOException {
		for (File fromFile : fromDirectory.listFiles()) {
			File toFile = new File(toDirectory, fromFile.getName());
			if (fromFile.isDirectory()) {
				toFile.mkdir();
				copyRecursively(fromFile, toFile);
			} else {
				copyFile(fromFile, toFile);
			}
		}
	}
	
	public static void readFileName(File fromDirectory){
		try{
			File toFile = new File("F:\\fileName.txt");
			BufferedOutputStream bufferStream = new BufferedOutputStream(new FileOutputStream(toFile));
			for (File fromFile : fromDirectory.listFiles()) {
				if(fromFile.isFile()){
					bufferStream.write(("lib\\"+fromFile.getName()).getBytes());
					bufferStream.write(" ".getBytes());
				}
			}
			bufferStream.flush();
			bufferStream.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
