import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class32 {
   @ObfuscatedName("m")
   static Calendar field723 = Calendar.getInstance();
   @ObfuscatedName("h")
   static String[] field724;
   @ObfuscatedName("u")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("r")
   static Widget field727;
   @ObfuscatedName("k")
   static int[] field728 = new int[1000];
   @ObfuscatedName("a")
   static int[] field729 = new int[5];
   @ObfuscatedName("x")
   static class11[] field730 = new class11[50];
   @ObfuscatedName("lg")
   static class216 field731;
   @ObfuscatedName("g")
   static int[][] field732 = new int[5][5000];
   @ObfuscatedName("j")
   static final String[] field733 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -84006225
   )
   static int field734 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -413957255
   )
   static int field735 = 0;
   @ObfuscatedName("s")
   public static class182 field737;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method665() {
      CombatInfo2.field2847.reset();
      CombatInfo2.field2837.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "1437241864"
   )
   public static int method666(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = class22.method192(var1);
      var0.method2846(var3.length);
      var0.offset += class210.field3121.method2647(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "666412371"
   )
   public static FileOnDisk method667(String var0, String var1, boolean var2) {
      File var3 = new File(class112.field1766, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class170.field2347 == 33) {
         var4 = "_rc";
      } else if(class170.field2347 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class104.field1692, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "-1869470170"
   )
   static final void method668(class68 var0) {
      var0.field1139 = false;
      if(null != var0.field1141) {
         var0.field1141.field1173 = 0;
      }

      for(class68 var1 = var0.vmethod2611(); null != var1; var1 = var0.vmethod2612()) {
         method668(var1);
      }

   }
}
