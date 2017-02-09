import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("r")
   static NodeCache field2814 = new NodeCache(64);
   @ObfuscatedName("y")
   public static class182 field2815;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2130551323
   )
   public int field2816 = 70;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -18620129
   )
   public int field2817;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1705586877
   )
   public int field2818 = 255;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2082228645
   )
   public int field2820 = 255;
   @ObfuscatedName("o")
   static NodeCache field2821 = new NodeCache(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -658411267
   )
   public int field2822 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1637192203
   )
   public int field2823 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -517904193
   )
   public int field2824 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -801455489
   )
   int field2825 = -1;
   @ObfuscatedName("k")
   public static class182 field2826;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 762391199
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -263843859
   )
   int field2828 = -1;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2113762966"
   )
   void method3512(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3517(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1504958035"
   )
   public SpritePixels method3515() {
      if(this.field2828 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2814.get((long)this.field2828);
         if(null != var1) {
            return var1;
         } else {
            var1 = class60.method1158(field2815, this.field2828, 0);
            if(var1 != null) {
               field2814.put(var1, (long)this.field2828);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "866509755"
   )
   void method3517(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2820 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2818 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2822 = 0;
      } else if(var2 == 5) {
         this.field2816 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2825 = var1.method3096();
      } else if(var2 == 8) {
         this.field2828 = var1.method3096();
      } else if(var2 == 11) {
         this.field2822 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2824 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "9334"
   )
   public SpritePixels method3526() {
      if(this.field2825 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2814.get((long)this.field2825);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class60.method1158(field2815, this.field2825, 0);
            if(null != var1) {
               field2814.put(var1, (long)this.field2825);
            }

            return var1;
         }
      }
   }
}
