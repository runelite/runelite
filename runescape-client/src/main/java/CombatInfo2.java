import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1970694945
   )
   int field2846;
   @ObfuscatedName("c")
   static IndexDataBase field2847;
   @ObfuscatedName("n")
   public static NodeCache field2848;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -900232287
   )
   public int field2849;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1209223443
   )
   public int field2850;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 368312965
   )
   public int field2851;
   @ObfuscatedName("d")
   public static IndexDataBase field2852;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 695511145
   )
   public int field2853;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -397132229
   )
   public int field2854;
   @ObfuscatedName("q")
   static NodeCache field2855;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -550239511
   )
   public int field2856;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 66869819
   )
   int field2857;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -401156867
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 31903217
   )
   public int field2859;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-38715019"
   )
   public static int method3540(int var0) {
      return var0 >> 11 & 63;
   }

   public CombatInfo2() {
      this.field2851 = 255;
      this.field2853 = 255;
      this.field2849 = -1;
      this.field2854 = 1;
      this.field2850 = 70;
      this.field2846 = -1;
      this.field2857 = -1;
      this.healthScale = 30;
      this.field2859 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1408206958"
   )
   void method3541(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2851 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2853 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2849 = 0;
      } else if(var2 == 5) {
         this.field2850 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2846 = var1.method2397();
      } else if(var2 == 8) {
         this.field2857 = var1.method2397();
      } else if(var2 == 11) {
         this.field2849 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2859 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "2069778067"
   )
   public SpritePixels method3542() {
      if(this.field2846 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2855.get((long)this.field2846);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Ignore.method203(field2847, this.field2846, 0);
            if(var1 != null) {
               field2855.put(var1, (long)this.field2846);
            }

            return var1;
         }
      }
   }

   static {
      field2848 = new NodeCache(64);
      field2855 = new NodeCache(64);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-553080840"
   )
   public void method3551(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3541(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "7494"
   )
   public SpritePixels method3552() {
      if(this.field2857 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2855.get((long)this.field2857);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Ignore.method203(field2847, this.field2857, 0);
            if(var1 != null) {
               field2855.put(var1, (long)this.field2857);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;LIndexDataBase;S)V",
      garbageValue = "1301"
   )
   public static void method3559(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      Widget.field2197 = var0;
      Widget.field2198 = var1;
      Widget.field2251 = var2;
      Widget.field2199 = var3;
      class133.widgets = new Widget[Widget.field2197.method3306()][];
      Widget.validInterfaces = new boolean[Widget.field2197.method3306()];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-730130662"
   )
   static int method3560(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class128.method2364(class32.field720[--class32.field715]);
      } else {
         var3 = var2?class200.field2894:Script.field942;
      }

      if(var0 == 1927) {
         if(class32.field716 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2316 == null) {
            return 0;
         } else {
            class18 var4 = new class18();
            var4.field189 = var3;
            var4.field196 = var3.field2316;
            var4.field197 = class32.field716 + 1;
            Client.field484.method2824(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
