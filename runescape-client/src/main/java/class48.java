import java.applet.Applet;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class48 extends CacheableNode {
   @ObfuscatedName("ag")
   static boolean field937;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1647840767
   )
   int field938;
   @ObfuscatedName("q")
   String[] field940;
   @ObfuscatedName("g")
   int[] field941;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 317936149
   )
   int field942;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 667846083
   )
   int field943;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1218688637
   )
   int field944;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -234960557
   )
   static int field945;
   @ObfuscatedName("x")
   int[] field947;
   @ObfuscatedName("o")
   static byte[][] field949;
   @ObfuscatedName("p")
   static NodeCache field952 = new NodeCache(128);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZB)V",
      garbageValue = "-72"
   )
   public static void method875(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1921 = 1;
      Item.field887 = var0;
      class181.field2695 = var1;
      Frames.field1569 = var2;
      class105.field1721 = var3;
      class138.field1922 = var4;
      class138.field1926 = 10000;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "30586861"
   )
   public static void method877(Buffer var0) {
      byte[] var1 = new byte[24];

      try {
         class104.field1683.method1369(0L);
         class104.field1683.method1370(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var5) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2808(var1, 0, 24);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "-20"
   )
   public static void method878(Applet var0, String var1) {
      class114.field1793 = var0;
      class114.field1792 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-913934666"
   )
   static void method879(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class181 var4 = (class181)class185.field2741.method2374(var2);
      if(null != var4) {
         class185.field2748.method2306(var4);
      }
   }
}
