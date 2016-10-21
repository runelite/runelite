import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1983852603
   )
   int field816 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1479847079
   )
   @Export("y")
   int y;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1992750591
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ar")
   boolean field819 = false;
   @ObfuscatedName("bc")
   int[] field820 = new int[4];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 25947361
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("bk")
   class205 field822 = new class205();
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -490667233
   )
   int field823 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -928899149
   )
   int field824 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -414225705
   )
   int field825 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2135577193
   )
   int field826 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1978075031
   )
   int field827 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1653591755
   )
   int field828 = -1;
   @ObfuscatedName("ai")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("ap")
   boolean field830;
   @ObfuscatedName("ak")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 2038358147
   )
   int field832 = 100;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 938748069
   )
   int field833 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1819782063
   )
   int field834 = 0;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 704882479
   )
   int field835 = 0;
   @ObfuscatedName("cp")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("ad")
   int[] field837 = new int[4];
   @ObfuscatedName("an")
   int[] field838 = new int[4];
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1965378813
   )
   int field839 = 200;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -661862839
   )
   int field840;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1423398495
   )
   int field841;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1052696357
   )
   int field842 = 1;
   @ObfuscatedName("al")
   byte field843 = 0;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 239270895
   )
   int field844 = -1;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -127975105
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -744162909
   )
   int field846;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -609470719
   )
   int field847 = -1;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -745260389
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1302794247
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 294956849
   )
   int field850 = 0;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1539293199
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1975473035
   )
   int field852 = 0;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1680904381
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 159826623
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1555463269
   )
   int field855 = 0;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -475826085
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("cb")
   byte[] field857 = new byte[10];
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 971107991
   )
   int field858;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1499522977
   )
   int field859;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1061318197
   )
   int field860;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1537130869
   )
   int field861;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -489290187
   )
   @Export("x")
   int x;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1044999553
   )
   int field864;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1853385765
   )
   int field865 = 0;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -725451163
   )
   int field866;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -1708218359
   )
   int field867 = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1637418421
   )
   int field868 = 0;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1892808759
   )
   int field869 = 32;
   @ObfuscatedName("av")
   int[] field870 = new int[4];
   @ObfuscatedName("cl")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1527954997
   )
   int field872 = 0;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 691531013
   )
   int field873;
   @ObfuscatedName("ab")
   int[] field874 = new int[4];
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1909347223
   )
   int field875 = 0;
   @ObfuscatedName("bv")
   boolean field877 = false;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "175320545"
   )
   final void method766() {
      this.field867 = 0;
      this.field875 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-13595"
   )
   final void method767(int var1) {
      class49 var2 = class0.method1(var1);

      for(class26 var3 = (class26)this.field822.method3932(); var3 != null; var3 = (class26)this.field822.method3928()) {
         if(var3.field642 == var2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1300285726"
   )
   final void method769(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field838[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class51 var14 = Ignore.method95(var1);
         var10 = var14.field1114;
         var11 = var14.field1105;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field838[0];
         } else if(var10 == 1) {
            var12 = this.field837[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field838[var13] < var12) {
                  var9 = var13;
                  var12 = this.field838[var13];
               }
            } else if(var10 == 1 && this.field837[var13] < var12) {
               var9 = var13;
               var12 = this.field837[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field843 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field843;
            this.field843 = (byte)((this.field843 + 1) % 4);
            if(this.field838[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field870[var9] = var1;
         this.field837[var9] = var2;
         this.field874[var9] = var3;
         this.field820[var9] = var4;
         this.field838[var9] = var6 + var11 + var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "362517897"
   )
   final void method770(int var1, int var2, int var3, int var4, int var5, int var6) {
      class49 var8 = (class49)class49.field1086.get((long)var1);
      class49 var7;
      if(null != var8) {
         var7 = var8;
      } else {
         byte[] var9 = class49.field1080.method3304(33, var1);
         var8 = new class49();
         if(null != var9) {
            var8.method984(new Buffer(var9));
         }

         class49.field1086.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      class26 var14 = null;
      class26 var10 = null;
      int var11 = var7.field1082;
      int var12 = 0;

      class26 var13;
      for(var13 = (class26)this.field822.method3932(); var13 != null; var13 = (class26)this.field822.method3928()) {
         ++var12;
         if(var13.field642.field1074 == var8.field1074) {
            var13.method605(var4 + var2, var5, var6, var3);
            return;
         }

         if(var13.field642.field1076 <= var8.field1076) {
            var14 = var13;
         }

         if(var13.field642.field1082 > var11) {
            var10 = var13;
            var11 = var13.field642.field1082;
         }
      }

      if(null != var10 || var12 < 4) {
         var13 = new class26(var8);
         if(null == var14) {
            this.field822.method3930(var13);
         } else {
            class205.method3936(var13, var14);
         }

         var13.method605(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1522441533"
   )
   static final void method774() {
      int var0 = 64 + class181.field2950 * 128;
      int var1 = 64 + class180.field2946 * 128;
      int var2 = Renderable.method1960(var0, var1, XItemContainer.plane) - class128.field2093;
      if(class139.cameraX < var0) {
         class139.cameraX += (var0 - class139.cameraX) * class181.field2953 / 1000 + BufferProvider.field1447;
         if(class139.cameraX > var0) {
            class139.cameraX = var0;
         }
      }

      if(class139.cameraX > var0) {
         class139.cameraX -= class181.field2953 * (class139.cameraX - var0) / 1000 + BufferProvider.field1447;
         if(class139.cameraX < var0) {
            class139.cameraX = var0;
         }
      }

      if(class172.cameraZ < var2) {
         class172.cameraZ += BufferProvider.field1447 + (var2 - class172.cameraZ) * class181.field2953 / 1000;
         if(class172.cameraZ > var2) {
            class172.cameraZ = var2;
         }
      }

      if(class172.cameraZ > var2) {
         class172.cameraZ -= class181.field2953 * (class172.cameraZ - var2) / 1000 + BufferProvider.field1447;
         if(class172.cameraZ < var2) {
            class172.cameraZ = var2;
         }
      }

      if(class77.cameraY < var1) {
         class77.cameraY += class181.field2953 * (var1 - class77.cameraY) / 1000 + BufferProvider.field1447;
         if(class77.cameraY > var1) {
            class77.cameraY = var1;
         }
      }

      if(class77.cameraY > var1) {
         class77.cameraY -= class181.field2953 * (class77.cameraY - var1) / 1000 + BufferProvider.field1447;
         if(class77.cameraY < var1) {
            class77.cameraY = var1;
         }
      }

      var0 = class43.field985 * 128 + 64;
      var1 = 64 + class114.field2011 * 128;
      var2 = Renderable.method1960(var0, var1, XItemContainer.plane) - class139.field2149;
      int var3 = var0 - class139.cameraX;
      int var4 = var2 - class172.cameraZ;
      int var5 = var1 - class77.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class144.cameraPitch < var7) {
         class144.cameraPitch += (var7 - class144.cameraPitch) * class134.field2121 / 1000 + Item.field693;
         if(class144.cameraPitch > var7) {
            class144.cameraPitch = var7;
         }
      }

      if(class144.cameraPitch > var7) {
         class144.cameraPitch -= class134.field2121 * (class144.cameraPitch - var7) / 1000 + Item.field693;
         if(class144.cameraPitch < var7) {
            class144.cameraPitch = var7;
         }
      }

      int var9 = var8 - Frames.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         Frames.cameraYaw += var9 * class134.field2121 / 1000 + Item.field693;
         Frames.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         Frames.cameraYaw -= Item.field693 + -var9 * class134.field2121 / 1000;
         Frames.cameraYaw &= 2047;
      }

      int var10 = var8 - Frames.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         Frames.cameraYaw = var8;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "4"
   )
   static World method775() {
      return World.field659 < World.field651?World.worldList[++World.field659 - 1]:null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)LFileOnDisk;",
      garbageValue = "124"
   )
   public static FileOnDisk method786(String var0, String var1, boolean var2) {
      File var3 = new File(class152.field2279, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(CollisionData.field1957 == 33) {
         var4 = "_rc";
      } else if(CollisionData.field1957 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class152.field2278, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1315988205"
   )
   boolean vmethod787() {
      return false;
   }
}
