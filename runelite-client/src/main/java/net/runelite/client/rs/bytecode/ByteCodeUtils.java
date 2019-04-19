package net.runelite.client.rs.bytecode;

import javassist.CtClass;
import net.runelite.client.RuneLite;
import net.runelite.http.api.RuneLiteAPI;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ByteCodeUtils {
    //TODO: Write method to delete old revision injected clients.
    public static File injectedClientFile = new File(RuneLite.RUNELITE_DIR + "/injectedClient-" + RuneLiteAPI.getVersion() + "-.jar");
    public static File hijackedClientFile = new File(RuneLite.RUNELITE_DIR + "/hijackedClient-" + RuneLiteAPI.getVersion() + "-.jar");

    public static JarOutputStream target;

    public static void updateHijackedJar() {
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        try {
            target = new JarOutputStream(new FileOutputStream(hijackedClientFile), manifest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<String> classesToSkip = new ArrayList<>();
            for (CtClass ct : ByteCodePatcher.modifiedClasses) {
                classesToSkip.add(ct.getName());
            }

            JarFile original = new JarFile(injectedClientFile);
            Enumeration<JarEntry> entries = original.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                boolean skip = false;
                for (CtClass ct : ByteCodePatcher.modifiedClasses) {
                    if ((ct.getName() + ".class").equals(entry.getName())) {
                        skip = true;
                    }
                }
                if (!skip)
                    add(entry);
            }

            for (CtClass ct : ByteCodePatcher.modifiedClasses) {
                add(ct);
            }

            target.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void add(CtClass ct) {
        try {
            JarEntry newEntry = new JarEntry(ct.getName() + ".class");
            target.putNextEntry(newEntry);
            target.write(ct.toBytecode());
            target.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void add(JarEntry entry) throws IOException {
        try {
            if (!entry.getName().startsWith("META") && !entry.getName().equals("")) {
                target.putNextEntry(entry);
                target.write(getBytesFromZipFile(entry.getName()));
                target.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] getBytesFromZipFile(String entryName) {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(injectedClientFile);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().equals(entryName)) {
                    InputStream stream = zipFile.getInputStream(entry);

                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    int nRead;
                    byte[] data = new byte[1024];
                    while ((nRead = stream.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, nRead);
                    }
                    buffer.flush();
                    return buffer.toByteArray();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
