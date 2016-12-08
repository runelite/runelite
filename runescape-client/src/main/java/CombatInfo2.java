import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("b")
   static NodeCache field2830 = new NodeCache(64);
   @ObfuscatedName("m")
   public static class182 field2831;
   @ObfuscatedName("g")
   static NodeCache field2832 = new NodeCache(64);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1627174975
   )
   public int field2833 = 70;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -67373641
   )
   public int field2834;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -711547175
   )
   public int field2835 = 1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -214979553
   )
   public int field2836 = 255;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1941167641
   )
   public int field2837 = -1;
   @ObfuscatedName("o")
   public static class182 field2838;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1260341039
   )
   public int field2839 = 255;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -834535713
   )
   int field2840 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -228973657
   )
   int field2841 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1587952325
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1786843387
   )
   public int field2843 = 0;
   @ObfuscatedName("bk")
   static class184 field2844;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1463151753"
   )
   void method3432(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2839 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2836 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2837 = 0;
      } else if(var2 == 5) {
         this.field2833 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2840 = var1.method2741();
      } else if(var2 == 8) {
         this.field2841 = var1.method2741();
      } else if(var2 == 11) {
         this.field2837 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2843 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "8"
   )
   public SpritePixels method3434() {
      if(this.field2841 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2832.get((long)this.field2841);
         if(null != var1) {
            return var1;
         } else {
            var1 = class152.method2709(field2831, this.field2841, 0);
            if(null != var1) {
               field2832.put(var1, (long)this.field2841);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "85"
   )
   void method3437(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3432(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "108"
   )
   public SpritePixels method3438() {
      if(this.field2840 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2832.get((long)this.field2840);
         if(null != var1) {
            return var1;
         } else {
            var1 = class152.method2709(field2831, this.field2840, 0);
            if(var1 != null) {
               field2832.put(var1, (long)this.field2840);
            }

            return var1;
         }
      }
   }
}
