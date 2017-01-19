import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1319401481
   )
   public int field2836 = 255;
   @ObfuscatedName("h")
   static NodeCache field2837 = new NodeCache(64);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1374266219
   )
   public int field2838;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 106030313
   )
   public int field2840 = 255;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1598975611
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -220737771
   )
   public int field2842 = -1;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1788956585
   )
   static int field2843;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -439191389
   )
   int field2844 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1013483119
   )
   int field2845 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1698795061
   )
   public int field2846 = 1;
   @ObfuscatedName("f")
   static NodeCache field2847 = new NodeCache(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 616242241
   )
   public int field2848 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -38532303
   )
   public int field2849 = 70;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "456742077"
   )
   void method3408(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3409(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "55"
   )
   void method3409(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2840 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2836 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2842 = 0;
      } else if(var2 == 5) {
         this.field2849 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2844 = var1.method2737();
      } else if(var2 == 8) {
         this.field2845 = var1.method2737();
      } else if(var2 == 11) {
         this.field2842 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2848 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1286957444"
   )
   public SpritePixels method3410() {
      if(this.field2844 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2837.get((long)this.field2844);
         if(null != var1) {
            return var1;
         } else {
            var1 = class37.method717(class118.field1848, this.field2844, 0);
            if(var1 != null) {
               field2837.put(var1, (long)this.field2844);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1641769123"
   )
   public SpritePixels method3411() {
      if(this.field2845 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2837.get((long)this.field2845);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class37.method717(class118.field1848, this.field2845, 0);
            if(var1 != null) {
               field2837.put(var1, (long)this.field2845);
            }

            return var1;
         }
      }
   }
}
