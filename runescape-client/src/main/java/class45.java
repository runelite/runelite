import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class45 {
   @ObfuscatedName("l")
   static int[] field918 = new int[2048];
   @ObfuscatedName("r")
   static Buffer[] field919 = new Buffer[2048];
   @ObfuscatedName("h")
   static byte[] field921 = new byte[2048];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1357906951
   )
   static int field923 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1955327049
   )
   static int field925 = 0;
   @ObfuscatedName("u")
   static byte[] field926 = new byte[2048];
   @ObfuscatedName("w")
   static int[] field927 = new int[2048];
   @ObfuscatedName("j")
   static int[] field928 = new int[2048];
   @ObfuscatedName("s")
   static int[] field929 = new int[2048];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1068987721
   )
   static int field930 = 0;
   @ObfuscatedName("d")
   static int[] field931 = new int[2048];
   @ObfuscatedName("p")
   static Buffer field932 = new Buffer(new byte[5000]);
   @ObfuscatedName("m")
   static int[] field934 = new int[2048];

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1270322947"
   )
   public static void method864() {
      if(class115.mouse != null) {
         class115 var0 = class115.mouse;
         class115 var1 = class115.mouse;
         class115 var2 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "-24"
   )
   static final void method866(class68 var0) {
      var0.field1167 = false;
      if(var0.field1164 != null) {
         var0.field1164.field1198 = 0;
      }

      for(class68 var1 = var0.vmethod2768(); var1 != null; var1 = var0.vmethod2753()) {
         method866(var1);
      }

   }

   class45() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1295864826"
   )
   public static synchronized long method867() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2130) {
         class155.field2129 += class155.field2130 - var0;
      }

      class155.field2130 = var0;
      return var0 + class155.field2129;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-2048483772"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class167.field2200, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var11 = new FileOnDisk(var3, "rw", 10000L);
            return var11;
         } catch (IOException var10) {
            ;
         }
      }

      String var4 = "";
      if(class104.field1715 == 33) {
         var4 = "_rc";
      } else if(class104.field1715 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(Sequence.field3074, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var9) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var8) {
         throw new RuntimeException();
      }
   }
}
