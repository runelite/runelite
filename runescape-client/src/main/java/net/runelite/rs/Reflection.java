package net.runelite.rs;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

public class Reflection {
   private static final boolean PRINT_DEBUG_MESSAGES = true;
   private static Map classes;

   public static Class findClass(String name) throws ClassNotFoundException {
      Class var1 = (Class)classes.get(name);
      if(var1 != null) {
         return var1;
      } else {
         System.out.println("Server requested dummy class " + name);
         return Class.forName(name);
      }
   }

   public static Field findField(Class clazz, String name) throws NoSuchFieldException {
      System.out.println("Looking for field " + name + " in " + clazz);
      Field[] var2 = clazz.getDeclaredFields();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Field var5 = var2[var4];
         ObfuscatedName var6 = (ObfuscatedName)var5.getAnnotation(ObfuscatedName.class);
         if(var6 != null && var6.value().equals(name)) {
            return var5;
         }
      }

      System.out.println("Server requested dummy field " + name + " in " + clazz);
      return clazz.getDeclaredField(name);
   }

   public static String getMethodName(Method method) {
      ObfuscatedName var1 = (ObfuscatedName)method.getAnnotation(ObfuscatedName.class);
      return var1 != null?var1.value():method.getName();
   }

   public static Class[] getParameterTypes(Method method) {
      ObfuscatedSignature var1 = (ObfuscatedSignature)method.getAnnotation(ObfuscatedSignature.class);
      Class[] var2 = method.getParameterTypes();
      if(var1 == null) {
         return var2;
      } else {
         String var3 = var1.signature();
         int var4 = var3.lastIndexOf(41);
         char var5 = var3.charAt(var4 - 1);
         Class var6;
         switch(var5) {
         case 'B':
            var6 = Byte.TYPE;
            break;
         case 'I':
            var6 = Integer.TYPE;
            break;
         case 'S':
            var6 = Short.TYPE;
            break;
         default:
            throw new IllegalStateException();
         }

         var2 = (Class[])Arrays.copyOf(var2, var2.length + 1);
         var2[var2.length - 1] = var6;
         return var2;
      }
   }

   public static int getInt(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException {
      System.out.println("Getting field " + field);
      boolean var2 = false;
      if((field.getModifiers() & 2) == 0) {
         field.setAccessible(true);
         var2 = true;
      }

      int var3;
      try {
         var3 = field.getInt(obj);
      } catch (Exception var9) {
         var9.printStackTrace();
         throw var9;
      } finally {
         if(var2) {
            field.setAccessible(false);
         }

      }

      ObfuscatedGetter var4 = (ObfuscatedGetter)field.getAnnotation(ObfuscatedGetter.class);
      if(var4 != null) {
         int var5 = var4.intValue();
         int var6 = modInverse(var5);
         var3 *= var6;
      }

      return var3;
   }

   public static void setInt(Field field, Object obj, int value) throws IllegalArgumentException, IllegalAccessException {
      System.out.println("Setting field " + field + " to " + value);
      ObfuscatedGetter var3 = (ObfuscatedGetter)field.getAnnotation(ObfuscatedGetter.class);
      if(var3 != null) {
         int var4 = var3.intValue();
         value *= var4;
      }

      boolean var8 = false;
      if((field.getModifiers() & 2) == 0) {
         field.setAccessible(true);
         var8 = true;
      }

      try {
         field.setInt(obj, value);
      } finally {
         if(var8) {
            field.setAccessible(false);
         }

      }

   }

   public static BigInteger modInverse(BigInteger val, int bits) {
      BigInteger var2 = BigInteger.ONE.shiftLeft(bits);
      return val.modInverse(var2);
   }

   public static int modInverse(int val) {
      return modInverse(BigInteger.valueOf((long)val), 32).intValue();
   }

   public static Object invoke(Method method, Object object, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      System.out.println("Invoking " + method);

      try {
         return method.invoke(object, args);
      } catch (Throwable var4) {
         var4.printStackTrace();
         throw var4;
      }
   }

   static {
      classes = new HashMap();

      Path var2;
      try {
         for(Enumeration var0 = ClassLoader.getSystemResources(""); var0.hasMoreElements(); Files.walk(var2, new FileVisitOption[0]).filter((x$0) -> {
            return Files.isRegularFile(x$0, new LinkOption[0]);
         }).forEach((f) -> {
            String var1 = f.getName(f.getNameCount() - 1).toString().replace(".class", "");

            try {
               Class var3 = Class.forName(var1);
               ObfuscatedName var4 = (ObfuscatedName)var3.getAnnotation(ObfuscatedName.class);
               if(var3 != null) {
                  classes.put(var4.value(), var3);
               }
            } catch (ClassNotFoundException var4) {
               ;
            }

         })) {
            URL var1 = (URL)var0.nextElement();

            try {
               var2 = (new File(var1.toURI())).toPath();
            } catch (URISyntaxException var4) {
               var2 = (new File(var1.getPath())).toPath();
            }
         }
      } catch (IOException var5) {
         var5.printStackTrace();
      }

   }
}
