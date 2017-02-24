import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1297577069
   )
   int field2832 = -1;
   @ObfuscatedName("d")
   public static class182 field2833;
   @ObfuscatedName("h")
   public static NodeCache field2834 = new NodeCache(64);
   @ObfuscatedName("p")
   public static NodeCache field2835 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 101242355
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("q")
   public static class182 field2837;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1908467269
   )
   public int field2838 = 70;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -998966289
   )
   public int field2839 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1850495845
   )
   public int field2840 = 1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1657169841
   )
   public int field2841;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2082796201
   )
   int field2842 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -72534367
   )
   public int field2843 = 255;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -872742869
   )
   public int field2844 = 255;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1161726529
   )
   public int field2845 = 0;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2110198430"
   )
   void method3528(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3548(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1300201308"
   )
   public SpritePixels method3530() {
      if(this.field2832 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2835.get((long)this.field2832);
         if(null != var1) {
            return var1;
         } else {
            var1 = class182.method3305(field2833, this.field2832, 0);
            if(var1 != null) {
               field2835.put(var1, (long)this.field2832);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "915693357"
   )
   public SpritePixels method3544() {
      if(this.field2842 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2835.get((long)this.field2842);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class182.method3305(field2833, this.field2842, 0);
            if(var1 != null) {
               field2835.put(var1, (long)this.field2842);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1914944906"
   )
   void method3548(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2843 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2844 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2839 = 0;
      } else if(var2 == 5) {
         this.field2838 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2842 = var1.method3029();
      } else if(var2 == 8) {
         this.field2832 = var1.method3029();
      } else if(var2 == 11) {
         this.field2839 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2845 = var1.readUnsignedByte();
      }

   }
}
