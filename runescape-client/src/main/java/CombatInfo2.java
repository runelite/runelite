import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1514838151
   )
   public int field2834 = -1;
   @ObfuscatedName("g")
   public static NodeCache field2836 = new NodeCache(64);
   @ObfuscatedName("v")
   static NodeCache field2837 = new NodeCache(64);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -123423365
   )
   public int field2838;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 197362125
   )
   public int field2840 = 255;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1787809273
   )
   public int field2841 = 255;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2141364239
   )
   public int field2842 = 1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1289329879
   )
   public int field2843 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1169543473
   )
   int field2844 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -701060331
   )
   int field2845 = -1;
   @ObfuscatedName("x")
   public static class182 field2846;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1221329327
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 505109425
   )
   public int field2848 = 70;
   @ObfuscatedName("n")
   static class182 field2850;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "48"
   )
   public SpritePixels method3587() {
      if(this.field2845 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2837.get((long)this.field2845);
         if(null != var1) {
            return var1;
         } else {
            var1 = GameEngine.method2296(field2850, this.field2845, 0);
            if(null != var1) {
               field2837.put(var1, (long)this.field2845);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-6"
   )
   public void method3588(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3596(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1987271660"
   )
   public SpritePixels method3591() {
      if(this.field2844 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2837.get((long)this.field2844);
         if(null != var1) {
            return var1;
         } else {
            var1 = GameEngine.method2296(field2850, this.field2844, 0);
            if(null != var1) {
               field2837.put(var1, (long)this.field2844);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1469480861"
   )
   void method3596(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2840 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2841 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2834 = 0;
      } else if(var2 == 5) {
         this.field2848 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2845 = var1.method2901();
      } else if(var2 == 8) {
         this.field2844 = var1.method2901();
      } else if(var2 == 11) {
         this.field2834 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2843 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1231794318"
   )
   public static void method3606(class182 var0) {
      class5.field36 = var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "1"
   )
   static void method3607(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method3607(var0, var1, var2, var5 - 1);
         method3607(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "1912730233"
   )
   public static FileOnDisk method3608(String var0, String var1, boolean var2) {
      File var3 = new File(class206.field3100, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class171.field2347 == 33) {
         var4 = "_rc";
      } else if(class171.field2347 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(MessageNode.field229, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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
}
