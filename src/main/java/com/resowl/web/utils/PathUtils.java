package com.resowl.web.utils;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {
	
	/**
	 * Get current working directory
	 * @return String
	 */
	public static String getCwd() {
		return System.getProperty("user.dir");
	}
	
	/**
	 * Get Config Directory
	 * @param projectWd
	 * @return
	 */
	public static String getConfigDir(String projectWd) {
		Path filePath = Paths.get(projectWd, "src","main","java","com","resowl","web","config");
		return filePath.toString();
	}
	
	/**
	 * Get file path
	 * @param dirPath
	 * @param fileName
	 * @return
	 */
	public static String getFilePath(String dirPath, String fileName) {
		Path filePath = Paths.get(dirPath,fileName);
		return filePath.toString();
	}

}
