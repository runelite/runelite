import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class219 implements class218 {
   @ObfuscatedName("p")
   public static final class219 field2796;
   @ObfuscatedName("m")
   public static final class219 field2797;
   @ObfuscatedName("e")
   public static final class219 field2798;
   @ObfuscatedName("t")
   public static final class219 field2799;
   @ObfuscatedName("w")
   public static final class219 field2800;
   @ObfuscatedName("j")
   public static final class219 field2802;
   @ObfuscatedName("z")
   public static final class219 field2803;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 803336683
   )
   public final int field2804;
   @ObfuscatedName("c")
   public static final class219 field2805;
   @ObfuscatedName("i")
   public static final class219 field2806;
   @ObfuscatedName("dr")
   static IndexData field2807;
   @ObfuscatedName("f")
   static final class219 field2809;
   @ObfuscatedName("bn")
   static String field2810;

   static {
      field2796 = new class219("", 10);
      field2797 = new class219("", 11);
      field2798 = new class219("", 12);
      field2799 = new class219("", 13);
      field2800 = new class219("", 14);
      field2803 = new class219("", 15, new class6[]{class6.field102, class6.field102}, (class6[])null);
      field2802 = new class219("", 16, new class6[]{class6.field102, class6.field102}, (class6[])null);
      field2806 = new class219("", 17, new class6[]{class6.field102, class6.field102}, (class6[])null);
      field2809 = new class219("", 73, true, true);
      field2805 = new class219("", 76, true, false);
   }

   class219(String var1, int var2, class6[] var3, class6[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class219(String var1, int var2, boolean var3, class6[] var4, boolean var5, class6[] var6) {
      this.field2804 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field2804;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZZ)V",
      garbageValue = "1"
   )
   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (class6[])null, var4, (class6[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "10"
   )
   class219(String var1, int var2) {
      this(var1, var2, false, (class6[])null, false, (class6[])null);
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "306317487"
   )
   static final void method3949() {
      int var0 = class29.field436 * 128 + 64;
      int var1 = class2.field19 * 128 + 64;
      int var2 = class77.method1438(var0, var1, Player.plane) - class27.field415;
      if(class14.cameraX < var0) {
         class14.cameraX += (var0 - class14.cameraX) * GroundObject.field1870 / 1000 + XGrandExchangeOffer.field317;
         if(class14.cameraX > var0) {
            class14.cameraX = var0;
         }
      }

      if(class14.cameraX > var0) {
         class14.cameraX -= (class14.cameraX - var0) * GroundObject.field1870 / 1000 + XGrandExchangeOffer.field317;
         if(class14.cameraX < var0) {
            class14.cameraX = var0;
         }
      }

      if(class112.cameraZ < var2) {
         class112.cameraZ += XGrandExchangeOffer.field317 + (var2 - class112.cameraZ) * GroundObject.field1870 / 1000;
         if(class112.cameraZ > var2) {
            class112.cameraZ = var2;
         }
      }

      if(class112.cameraZ > var2) {
         class112.cameraZ -= (class112.cameraZ - var2) * GroundObject.field1870 / 1000 + XGrandExchangeOffer.field317;
         if(class112.cameraZ < var2) {
            class112.cameraZ = var2;
         }
      }

      if(class66.cameraY < var1) {
         class66.cameraY += XGrandExchangeOffer.field317 + GroundObject.field1870 * (var1 - class66.cameraY) / 1000;
         if(class66.cameraY > var1) {
            class66.cameraY = var1;
         }
      }

      if(class66.cameraY > var1) {
         class66.cameraY -= XGrandExchangeOffer.field317 + GroundObject.field1870 * (class66.cameraY - var1) / 1000;
         if(class66.cameraY < var1) {
            class66.cameraY = var1;
         }
      }

      var0 = Item.field1479 * 128 + 64;
      var1 = class18.field335 * 128 + 64;
      var2 = class77.method1438(var0, var1, Player.plane) - class152.field2231;
      int var3 = var0 - class14.cameraX;
      int var4 = var2 - class112.cameraZ;
      int var5 = var1 - class66.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class203.cameraPitch < var7) {
         class203.cameraPitch += (var7 - class203.cameraPitch) * class24.field372 / 1000 + MessageNode.field856;
         if(class203.cameraPitch > var7) {
            class203.cameraPitch = var7;
         }
      }

      if(class203.cameraPitch > var7) {
         class203.cameraPitch -= MessageNode.field856 + class24.field372 * (class203.cameraPitch - var7) / 1000;
         if(class203.cameraPitch < var7) {
            class203.cameraPitch = var7;
         }
      }

      int var9 = var8 - class13.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class13.cameraYaw += class24.field372 * var9 / 1000 + MessageNode.field856;
         class13.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class13.cameraYaw -= -var9 * class24.field372 / 1000 + MessageNode.field856;
         class13.cameraYaw &= 2047;
      }

      int var10 = var8 - class13.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class13.cameraYaw = var8;
      }

   }
}
