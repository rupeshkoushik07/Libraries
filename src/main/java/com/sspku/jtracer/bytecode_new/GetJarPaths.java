//the changes made here are to get the jar paths from the deps folder instead of default m2
// i had issue with resolving the path 

/*                pre = pre.replace("[INFO] ", "")
                        .replace("\\- ", "")
                        .replace("+-", "")
                        .replace("|", "")
                        .replaceAll(" ", "")
                        .replaceAll("\\.", "/");*/

package com.sspku.jtracer.bytecode_new;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetJarPaths {

    public List<String> getJarPaths(String groupId, String artifactId) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        
        // Look for JAR files in target/deps directory
        String depsDir = System.getProperty("user.dir") + "/target/deps/";
        File depsFolder = new File(depsDir);
        
        if (!depsFolder.exists() || !depsFolder.isDirectory()) {
            System.out.println("Deps directory not found: " + depsDir);
            return result;
        }
        
        File[] jarFiles = depsFolder.listFiles((dir, name) -> name.endsWith(".jar"));
        if (jarFiles != null) {
            for (File jarFile : jarFiles) {
                result.add(jarFile.getName());
                System.out.println("Found JAR: " + jarFile.getName());
            }
        }
        
        return result;
    }
}
