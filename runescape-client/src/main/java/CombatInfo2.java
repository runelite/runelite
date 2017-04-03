import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 183328135
   )
   public int field2839 = 255;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2061854867
   )
   public int field2840 = 70;
   @ObfuscatedName("u")
   public static NodeCache field2841 = new NodeCache(64);
   @ObfuscatedName("i")
   public static IndexDataBase field2842;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1953350061
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1781274899
   )
   public int field2845;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1524552929
   )
   public int field2847 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1891039841
   )
   public int field2848 = 1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 486518699
   )
   public int field2849 = 255;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1853878685
   )
   int field2850 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 484457901
   )
   int field2851 = -1;
   @ObfuscatedName("f")
   public static IndexDataBase field2852;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -508738477
   )
   public int field2853 = 0;
   @ObfuscatedName("h")
   static NodeCache field2854 = new NodeCache(64);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1979886059"
   )
   public void method3572(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3575(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "-747"
   )
   public SpritePixels method3573() {
      if(this.field2850 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2854.get((long)this.field2850);
         if(null != var1) {
            return var1;
         } else {
            var1 = class26.method564(field2842, this.field2850, 0);
            if(var1 != null) {
               field2854.put(var1, (long)this.field2850);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1415980020"
   )
   public SpritePixels method3574() {
      if(this.field2851 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2854.get((long)this.field2851);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class26.method564(field2842, this.field2851, 0);
            if(var1 != null) {
               field2854.put(var1, (long)this.field2851);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method3575(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2839 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2849 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2847 = 0;
      } else if(var2 == 5) {
         this.field2840 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2850 = var1.method2882();
      } else if(var2 == 8) {
         this.field2851 = var1.method2882();
      } else if(var2 == 11) {
         this.field2847 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2853 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1731232770"
   )
   public static int method3589(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
