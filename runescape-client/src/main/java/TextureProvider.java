import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("w")
   double field1206 = 1.0D;
   @ObfuscatedName("x")
   class79[] field1207;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -273079699
   )
   int field1208;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -79300955
   )
   int field1209 = 0;
   @ObfuscatedName("j")
   Deque field1210 = new Deque();
   @ObfuscatedName("u")
   class182 field1211;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 213450713
   )
   int field1212 = 128;
   @ObfuscatedName("ky")
   static Widget[] field1213;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "13"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1207[var1];
      if(null != var2) {
         if(var2.field1318 != null) {
            this.field1210.method2444(var2);
            var2.field1312 = true;
            return var2.field1318;
         }

         boolean var3 = var2.method1599(this.field1206, this.field1212, this.field1211);
         if(var3) {
            if(this.field1209 == 0) {
               class79 var4 = (class79)this.field1210.method2469();
               var4.method1601();
            } else {
               --this.field1209;
            }

            this.field1210.method2444(var2);
            var2.field1312 = true;
            return var2.field1318;
         }
      }

      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.8"
   )
   public void method1497(double var1) {
      this.field1206 = var1;
      this.method1499();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-106"
   )
   public int vmethod1965(int var1) {
      return null != this.field1207[var1]?this.field1207[var1].field1320:0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2034329726"
   )
   public void method1499() {
      for(int var1 = 0; var1 < this.field1207.length; ++var1) {
         if(null != this.field1207[var1]) {
            this.field1207[var1].method1601();
         }
      }

      this.field1210 = new Deque();
      this.field1209 = this.field1208;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "9"
   )
   public void method1500(int var1) {
      for(int var2 = 0; var2 < this.field1207.length; ++var2) {
         class79 var3 = this.field1207[var2];
         if(null != var3 && var3.field1322 != 0 && var3.field1312) {
            var3.method1607(var1);
            var3.field1312 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1211 = var2;
      this.field1208 = var3;
      this.field1209 = this.field1208;
      this.field1206 = var4;
      this.field1212 = var6;
      int[] var7 = var1.method3313(0);
      int var8 = var7.length;
      this.field1207 = new class79[var1.method3316(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1207[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-550940940"
   )
   public boolean vmethod1966(int var1) {
      return this.field1207[var1].field1325;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1005651214"
   )
   public boolean vmethod1967(int var1) {
      return this.field1212 == 64;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   static void method1515() {
      int var0 = GameEngine.field1785;
      int var1 = GameEngine.field1790;
      int var2 = class16.field208 - class108.field1748 - var0;
      int var3 = class178.field2668 - class145.field2018 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field308.method2169();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class16.field206) {
               Insets var7 = class16.field206.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class178.field2668);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class16.field208, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class16.field208 + var5 - var2, var6, var2, class178.field2668);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class178.field2668 - var3, class16.field208, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IIB)LFont;",
      garbageValue = "29"
   )
   public static Font method1516(class182 var0, class182 var1, int var2, int var3) {
      return !class65.method1246(var0, var2, var3)?null:class101.method2018(var1.getConfigData(var2, var3));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-929024217"
   )
   public static void method1517() {
      if(class105.keyboard != null) {
         class105 var0 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

   }
}
