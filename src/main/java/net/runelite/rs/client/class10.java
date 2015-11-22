package net.runelite.rs.client;

import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("s")
public class class10 extends class106 {
   @ObfuscatedName("eh")
   static class78[] field155;
   @ObfuscatedName("gl")
   static class172 field156;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1514328843
   )
   static int field157;
   @ObfuscatedName("bn")
   static class80 field159;
   @ObfuscatedName("au")
   static class142 field160;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1383770245
   )
   static int field161;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -64971617
   )
   static int field164;

   @ObfuscatedName("j")
   public boolean vmethod2416(int var1, int var2) {
      return super.field1860 == var1 && var2 == super.field1858;
   }

   @ObfuscatedName("j")
   public static class43 method156(int var0) {
      class43 var1 = (class43)class43.field993.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class43.field991.method3352(13, var0);
         var1 = new class43();
         var1.field995 = var0;
         if(var2 != null) {
            var1.method947(new class118(var2));
         }

         class43.field993.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   static boolean method157(String var0, int var1, String var2) {
      if(0 == var1) {
         try {
            if(!class137.field2117.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(1 == var1) {
         try {
            Object var3 = class131.method2877(class137.field2116, var2, new Object[]{(new URL(class137.field2116.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(2 == var1) {
         try {
            class137.field2116.getAppletContext().showDocument(new URL(class137.field2116.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class131.method2879(class137.field2116, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class137.field2116.getAppletContext().showDocument(new URL(class137.field2116.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("m")
   public static class51 method158(int var0) {
      class51 var1 = (class51)class51.field1093.method3808((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class221.field3164.method3352(10, var0);
         var1 = new class51();
         var1.field1097 = var0;
         if(null != var2) {
            var1.method1114(new class118(var2));
         }

         var1.method1080();
         if(-1 != var1.field1114) {
            var1.method1070(method158(var1.field1114), method158(var1.field1104));
         }

         if(var1.field1125 != -1) {
            var1.method1071(method158(var1.field1125), method158(var1.field1138));
         }

         if(!class102.field1750 && var1.field1112) {
            var1.field1099 = "Members object";
            var1.field1137 = false;
            var1.field1108 = null;
            var1.field1116 = null;
            var1.field1124 = 0;
         }

         class51.field1093.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("dc")
   static String method159(class172 var0, int var1) {
      int var3 = class7.method126(var0);
      boolean var2 = 0 != (var3 >> var1 + 1 & 1);
      return !var2 && null == var0.field2766?null:(null != var0.field2786 && var0.field2786.length > var1 && null != var0.field2786[var1] && var0.field2786[var1].trim().length() != 0?var0.field2786[var1]:null);
   }
}
