package net.runelite.rs.client;

import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class134 {
   @ObfuscatedName("f")
   static Hashtable field2064 = new Hashtable(16);
   @ObfuscatedName("m")
   public static File field2065;
   @ObfuscatedName("j")
   public static boolean field2066 = false;

   @ObfuscatedName("e")
   public static String method2909(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("m")
   static void method2910() {
      for(class23 var0 = (class23)class23.field590.method3871(); null != var0; var0 = (class23)class23.field590.method3873()) {
         if(null != var0.field593) {
            var0.method620();
         }
      }

   }
}
