import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -125130413
   )
   int field595 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -92611231
   )
   @Export("y")
   int y;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -714941335
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ai")
   boolean field598 = false;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1286333537
   )
   int field599 = 1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -111939829
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1222734887
   )
   int field601 = -1;
   @ObfuscatedName("ax")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 920470781
   )
   int field603 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2067034693
   )
   int field604 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1019672581
   )
   int field605 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -2126360025
   )
   int field606 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 624743125
   )
   int field607 = 100;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -451437001
   )
   int field608;
   @ObfuscatedName("ad")
   boolean field609;
   @ObfuscatedName("ah")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("bt")
   class126 field611 = new class126();
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -255374045
   )
   int field612 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 218788827
   )
   int field613 = 0;
   @ObfuscatedName("au")
   byte field614 = 0;
   @ObfuscatedName("ak")
   int[] field615 = new int[4];
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 992596573
   )
   int field616 = 0;
   @ObfuscatedName("aj")
   int[] field617 = new int[4];
   @ObfuscatedName("ao")
   int[] field618 = new int[4];
   @ObfuscatedName("ar")
   int[] field619 = new int[4];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1246852625
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 346980259
   )
   int field621 = 200;
   @ObfuscatedName("bd")
   boolean field622 = false;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -408048489
   )
   int field623 = -1;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -500060679
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("cy")
   byte[] field625 = new byte[10];
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1736299439
   )
   int field626 = 0;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1777934733
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("cc")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1491847805
   )
   int field629 = 32;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -592226693
   )
   int field630 = -1;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1093492991
   )
   int field631 = 0;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 212843897
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 436856935
   )
   int field633 = 0;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -192696737
   )
   int field634 = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1434361873
   )
   int field635 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -656023305
   )
   int field636;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1512099575
   )
   int field637;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 90738093
   )
   int field638;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -625984089
   )
   int field639;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1164100373
   )
   int field640;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1070354391
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1507893037
   )
   int field642;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -78955783
   )
   int field643;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -687075349
   )
   int field644 = 0;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1191265729
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -53315953
   )
   int field646;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1488230921
   )
   @Export("x")
   int x;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -363136285
   )
   int field648;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -2065257393
   )
   int field649 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 14370547
   )
   int field650 = -1;
   @ObfuscatedName("cs")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 656523331
   )
   static int field652;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1098927225
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1615946649
   )
   int field654 = 0;
   @ObfuscatedName("bn")
   int[] field655 = new int[4];

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-79"
   )
   final void method617() {
      this.field649 = 0;
      this.field654 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1389298352"
   )
   boolean vmethod746() {
      return false;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1377627724"
   )
   final void method620(int var1, int var2, int var3, int var4, int var5, int var6) {
      class193 var8 = (class193)class193.field2833.get((long)var1);
      class193 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = class193.field2843.method3329(33, var1);
         var8 = new class193();
         if(var9 != null) {
            var8.method3579(new Buffer(var9));
         }

         class193.field2833.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      class34 var14 = null;
      class34 var10 = null;
      int var11 = var7.field2840;
      int var12 = 0;

      class34 var13;
      for(var13 = (class34)this.field611.method2428(); var13 != null; var13 = (class34)this.field611.method2420()) {
         ++var12;
         if(var8.field2835 == var13.field744.field2835) {
            var13.method717(var4 + var2, var5, var6, var3);
            return;
         }

         if(var13.field744.field2838 <= var8.field2838) {
            var14 = var13;
         }

         if(var13.field744.field2840 > var11) {
            var10 = var13;
            var11 = var13.field744.field2840;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new class34(var8);
         if(var14 == null) {
            this.field611.method2434(var13);
         } else {
            class126.method2423(var13, var14);
         }

         var13.method717(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "358944356"
   )
   final void method621(int var1) {
      class193 var3 = (class193)class193.field2833.get((long)var1);
      class193 var2;
      if(null != var3) {
         var2 = var3;
      } else {
         byte[] var4 = class193.field2843.method3329(33, var1);
         var3 = new class193();
         if(null != var4) {
            var3.method3579(new Buffer(var4));
         }

         class193.field2833.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(class34 var5 = (class34)this.field611.method2428(); null != var5; var5 = (class34)this.field611.method2420()) {
         if(var5.field744 == var3) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2052274150"
   )
   final void method624(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field617[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var12 = class6.method92(var1);
         var10 = var12.field2884;
         var11 = var12.field2867;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.field617[0];
         } else if(var10 == 1) {
            var14 = this.field619[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field617[var13] < var14) {
                  var9 = var13;
                  var14 = this.field617[var13];
               }
            } else if(var10 == 1 && this.field619[var13] < var14) {
               var9 = var13;
               var14 = this.field619[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field614 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field614;
            this.field614 = (byte)((this.field614 + 1) % 4);
            if(this.field617[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field615[var9] = var1;
         this.field619[var9] = var2;
         this.field618[var9] = var3;
         this.field655[var9] = var4;
         this.field617[var9] = var6 + var5 + var11;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-19"
   )
   static final boolean method630() {
      if(FileOnDisk.field1183 == null) {
         return false;
      } else {
         int var2;
         String var17;
         try {
            int var0 = FileOnDisk.field1183.method2105();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               FileOnDisk.field1183.method2106(Client.field370.payload, 0, 1);
               Client.field370.offset = 0;
               Client.packetOpcode = Client.field370.method3235();
               Client.field564 = class212.field3117[Client.packetOpcode];
               --var0;
            }

            if(Client.field564 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               FileOnDisk.field1183.method2106(Client.field370.payload, 0, 1);
               Client.field564 = Client.field370.payload[0] & 255;
               --var0;
            }

            if(Client.field564 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               FileOnDisk.field1183.method2106(Client.field370.payload, 0, 2);
               Client.field370.offset = 0;
               Client.field564 = Client.field370.readUnsignedShort();
               var0 -= 2;
            }

            if(var0 < Client.field564) {
               return false;
            }

            Client.field370.offset = 0;
            FileOnDisk.field1183.method2106(Client.field370.payload, 0, Client.field564);
            Client.field335 = 0;
            Client.field339 = Client.field338;
            Client.field338 = Client.field482 * -1;
            Client.field482 = Client.packetOpcode * -1;
            int var1;
            Widget var3;
            if(Client.packetOpcode == 63) {
               var1 = Client.field370.method2995();
               var2 = Client.field370.readUnsignedShort();
               var3 = class5.method79(var1);
               if(var3.modelType != 2 || var2 != var3.modelId) {
                  var3.modelType = 2;
                  var3.modelId = var2;
                  Tile.method1577(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 128) {
               Client.field553 = 1;
               Client.field388 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 70) {
               var1 = Client.field370.readUnsignedByte();
               if(Client.field370.readUnsignedByte() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field370.offset += 18;
               } else {
                  --Client.field370.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field370, false);
               }

               Client.field480 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            int var10;
            long var58;
            long var59;
            long var78;
            if(Client.packetOpcode == 99) {
               var17 = Client.field370.method3057();
               var58 = (long)Client.field370.readUnsignedShort();
               var78 = (long)Client.field370.read24BitInt();
               class177 var47 = (class177)class101.method1985(class65.method1170(), Client.field370.readUnsignedByte());
               var59 = (var58 << 32) + var78;
               boolean var73 = false;

               for(var10 = 0; var10 < 100; ++var10) {
                  if(var59 == Client.field506[var10]) {
                     var73 = true;
                     break;
                  }
               }

               if(class186.method3472(var17)) {
                  var73 = true;
               }

               if(!var73 && Client.field366 == 0) {
                  Client.field506[Client.field550] = var59;
                  Client.field550 = (Client.field550 + 1) % 100;
                  String var68 = class209.method3979(PlayerComposition.method2823(class159.method2973(Client.field370)));
                  byte var69;
                  if(var47.field2674) {
                     var69 = 7;
                  } else {
                     var69 = 3;
                  }

                  if(var47.field2677 != -1) {
                     class10.method120(var69, class9.method116(var47.field2677) + var17, var68);
                  } else {
                     class10.method120(var69, var17, var68);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 179) {
               Client.flagX = Client.field370.readUnsignedByte();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field370.readUnsignedByte();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 124) {
               if(Client.widgetRoot != -1) {
                  XItemContainer.method181(Client.widgetRoot, 0);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 46) {
               Client.field533 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field429[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var4;
            int var19;
            if(Client.packetOpcode == 114) {
               var1 = Client.field370.readUnsignedByte();
               var2 = Client.field370.readUnsignedByte();
               var19 = Client.field370.readUnsignedByte();
               var4 = Client.field370.readUnsignedByte();
               Client.field429[var1] = true;
               Client.field535[var1] = var2;
               Client.field536[var1] = var19;
               Client.field537[var1] = var4;
               Client.field471[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 156) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(null != Client.cachedPlayers[var1]) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(null != Client.cachedNPCs[var1]) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 177) {
               var1 = Client.field370.method3025();
               byte var61 = Client.field370.method3020();
               class146.settings[var1] = var61;
               if(var61 != class146.widgetSettings[var1]) {
                  class146.widgetSettings[var1] = var61;
               }

               class41.method801(var1);
               Client.field400[++Client.field472 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 76) {
               class18.method204(true);
               Client.packetOpcode = -1;
               return true;
            }

            int var5;
            int var20;
            if(Client.packetOpcode == 90) {
               var1 = Client.field370.readUnsignedShort();
               var2 = Client.field370.method3067();
               var19 = var1 >> 10 & 31;
               var4 = var1 >> 5 & 31;
               var5 = var1 & 31;
               var20 = (var4 << 11) + (var19 << 19) + (var5 << 3);
               Widget var77 = class5.method79(var2);
               if(var77.textColor != var20) {
                  var77.textColor = var20;
                  Tile.method1577(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var7;
            if(Client.packetOpcode == 80) {
               Client.field533 = true;
               class145.field2021 = Client.field370.readUnsignedByte();
               class37.field787 = Client.field370.readUnsignedByte();
               class143.field2006 = Client.field370.readUnsignedShort();
               XItemContainer.field128 = Client.field370.readUnsignedByte();
               class9.field83 = Client.field370.readUnsignedByte();
               if(class9.field83 >= 100) {
                  var1 = class145.field2021 * 128 + 64;
                  var2 = 64 + class37.field787 * 128;
                  var19 = class11.method161(var1, var2, class166.plane) - class143.field2006;
                  var4 = var1 - XGrandExchangeOffer.cameraX;
                  var5 = var19 - Client.cameraZ;
                  var20 = var2 - Client.cameraY;
                  var7 = (int)Math.sqrt((double)(var4 * var4 + var20 * var20));
                  class40.cameraPitch = (int)(Math.atan2((double)var5, (double)var7) * 325.949D) & 2047;
                  class104.cameraYaw = (int)(Math.atan2((double)var4, (double)var20) * -325.949D) & 2047;
                  if(class40.cameraPitch < 128) {
                     class40.cameraPitch = 128;
                  }

                  if(class40.cameraPitch > 383) {
                     class40.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var74;
            if(Client.packetOpcode == 58) {
               var1 = Client.field370.method3036();
               var2 = Client.field370.method3025();
               var19 = Client.field370.method3025();
               var4 = Client.field370.method3025();
               var74 = class5.method79(var1);
               if(var74.rotationX != var19 || var4 != var74.rotationZ || var2 != var74.field2134) {
                  var74.rotationX = var19;
                  var74.rotationZ = var4;
                  var74.field2134 = var2;
                  Tile.method1577(var74);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 203) {
               class7.field65 = Client.field370.method3017();
               class3.field32 = Client.field370.method3019();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 39) {
               class182.method3405();
               Client.weight = Client.field370.method2993();
               Client.field379 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 235) {
               for(var1 = 0; var1 < class146.widgetSettings.length; ++var1) {
                  if(class146.settings[var1] != class146.widgetSettings[var1]) {
                     class146.widgetSettings[var1] = class146.settings[var1];
                     class41.method801(var1);
                     Client.field400[++Client.field472 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 119) {
               var1 = Client.field370.method3153();
               var2 = Client.field370.method3067();
               var3 = class5.method79(var2);
               if(null != var3 && var3.type == 0) {
                  if(var1 > var3.scrollHeight - var3.height) {
                     var1 = var3.scrollHeight - var3.height;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var3.scrollY != var1) {
                     var3.scrollY = var1;
                     Tile.method1577(var3);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var12;
            long var54;
            boolean var55;
            long var72;
            if(Client.packetOpcode == 20) {
               var17 = Client.field370.method3057();
               var58 = Client.field370.method3118();
               var78 = (long)Client.field370.readUnsignedShort();
               var72 = (long)Client.field370.read24BitInt();
               class177 var43 = (class177)class101.method1985(class65.method1170(), Client.field370.readUnsignedByte());
               var54 = var72 + (var78 << 32);
               var55 = false;

               for(var12 = 0; var12 < 100; ++var12) {
                  if(var54 == Client.field506[var12]) {
                     var55 = true;
                     break;
                  }
               }

               if(var43.field2673 && class186.method3472(var17)) {
                  var55 = true;
               }

               if(!var55 && Client.field366 == 0) {
                  Client.field506[Client.field550] = var54;
                  Client.field550 = (1 + Client.field550) % 100;
                  String var80 = class209.method3979(PlayerComposition.method2823(class159.method2973(Client.field370)));
                  if(var43.field2677 != -1) {
                     class37.addChatMessage(9, class9.method116(var43.field2677) + var17, var80, class11.method159(var58));
                  } else {
                     class37.addChatMessage(9, var17, var80, class11.method159(var58));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 117 || Client.packetOpcode == 16 || Client.packetOpcode == 208 || Client.packetOpcode == 243 || Client.packetOpcode == 209 || Client.packetOpcode == 175 || Client.packetOpcode == 165 || Client.packetOpcode == 50 || Client.packetOpcode == 169 || Client.packetOpcode == 107) {
               class13.method183();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 64) {
               class182.method3405();
               var1 = Client.field370.method3017();
               var2 = Client.field370.method3019();
               var19 = Client.field370.method3067();
               Client.skillExperiences[var1] = var19;
               Client.boostedSkillLevels[var1] = var2;
               Client.realSkillLevels[var1] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var19 >= class172.field2362[var4]) {
                     Client.realSkillLevels[var1] = 2 + var4;
                  }
               }

               Client.field475[++Client.field476 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            Widget var24;
            if(Client.packetOpcode == 32) {
               var1 = Client.field370.method3153();
               var2 = Client.field370.readUnsignedShort();
               var19 = Client.field370.method2995();
               var24 = class5.method79(var19);
               var24.field2112 = var1 + (var2 << 16);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 216) {
               Client.field533 = true;
               class49.field948 = Client.field370.readUnsignedByte();
               field652 = Client.field370.readUnsignedByte();
               class63.field1085 = Client.field370.readUnsignedShort();
               Renderable.field1535 = Client.field370.readUnsignedByte();
               RSCanvas.field1758 = Client.field370.readUnsignedByte();
               if(RSCanvas.field1758 >= 100) {
                  XGrandExchangeOffer.cameraX = 64 + class49.field948 * 128;
                  Client.cameraY = field652 * 128 + 64;
                  Client.cameraZ = class11.method161(XGrandExchangeOffer.cameraX, Client.cameraY, class166.plane) - class63.field1085;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 164) {
               var1 = Client.field370.readUnsignedShort();
               Client.widgetRoot = var1;
               class101.method1990(Client.widgetRoot, class16.field169, class65.field1103, false);
               Client.method603(var1);
               class7.method103(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field490[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 87) {
               var2 = Client.field370.readUnsignedByte();
               class216[] var51 = new class216[]{class216.field3154, class216.field3156, class216.field3155};
               class216[] var96 = var51;
               var5 = 0;

               class216 var70;
               while(true) {
                  if(var5 >= var96.length) {
                     var70 = null;
                     break;
                  }

                  class216 var46 = var96[var5];
                  if(var2 == var46.field3153) {
                     var70 = var46;
                     break;
                  }

                  ++var5;
               }

               Client.field568 = var70;
               Client.packetOpcode = -1;
               return true;
            }

            int var11;
            String var37;
            long var53;
            int var92;
            boolean var94;
            if(Client.packetOpcode == 45) {
               Client.field479 = Client.field470;
               if(Client.field564 == 0) {
                  Client.field512 = null;
                  Client.field328 = null;
                  class60.field1072 = 0;
                  class164.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.field328 = Client.field370.method3057();
               long var56 = Client.field370.method3118();
               var78 = var56;
               if(var56 > 0L && var56 < 6582952005840035281L) {
                  if(var56 % 37L == 0L) {
                     var37 = null;
                  } else {
                     var20 = 0;

                     for(var59 = var56; 0L != var59; var59 /= 37L) {
                        ++var20;
                     }

                     StringBuilder var88 = new StringBuilder(var20);

                     while(0L != var78) {
                        var53 = var78;
                        var78 /= 37L;
                        var88.append(class205.field3074[(int)(var53 - 37L * var78)]);
                     }

                     var37 = var88.reverse().toString();
                  }
               } else {
                  var37 = null;
               }

               Client.field512 = var37;
               XClanMember.field273 = Client.field370.method3047();
               var20 = Client.field370.readUnsignedByte();
               if(var20 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               class60.field1072 = var20;
               XClanMember[] var76 = new XClanMember[100];

               for(var92 = 0; var92 < class60.field1072; ++var92) {
                  var76[var92] = new XClanMember();
                  var76[var92].username = Client.field370.method3057();
                  var76[var92].field277 = class162.method3194(var76[var92].username, class108.field1740);
                  var76[var92].world = Client.field370.readUnsignedShort();
                  var76[var92].rank = Client.field370.method3047();
                  Client.field370.method3057();
                  if(var76[var92].username.equals(class40.localPlayer.name)) {
                     WidgetNode.field175 = var76[var92].rank;
                  }
               }

               var94 = false;
               var10 = class60.field1072;

               while(var10 > 0) {
                  var94 = true;
                  --var10;

                  for(var11 = 0; var11 < var10; ++var11) {
                     if(var76[var11].field277.compareTo(var76[1 + var11].field277) > 0) {
                        XClanMember var90 = var76[var11];
                        var76[var11] = var76[var11 + 1];
                        var76[1 + var11] = var90;
                        var94 = false;
                     }
                  }

                  if(var94) {
                     break;
                  }
               }

               class164.clanMembers = var76;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var50;
            if(Client.packetOpcode == 228) {
               var1 = Client.field370.method3037();
               var50 = Client.field370.method3019() == 1;
               var3 = class5.method79(var1);
               if(var50 != var3.isHidden) {
                  var3.isHidden = var50;
                  Tile.method1577(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 192) {
               class182.method3405();
               Client.energy = Client.field370.readUnsignedByte();
               Client.field379 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var49;
            String var84;
            if(Client.packetOpcode == 214) {
               var1 = Client.field370.method3003();
               var50 = Client.field370.readUnsignedByte() == 1;
               var37 = "";
               var49 = false;
               if(var50) {
                  var37 = Client.field370.method3057();
                  if(class186.method3472(var37)) {
                     var49 = true;
                  }
               }

               var84 = Client.field370.method3057();
               if(!var49) {
                  class10.method120(var1, var37, var84);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 204) {
               DecorativeObject.method1951();

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               class32.method705(Client.field370);
               Client.packetOpcode = -1;
               return true;
            }

            class166 var65;
            if(Client.packetOpcode == 12) {
               Client.field370.offset += 28;
               if(Client.field370.method3013()) {
                  var65 = Client.field370;
                  var2 = Client.field370.offset - 28;
                  if(null != class104.field1689) {
                     try {
                        class104.field1689.method1425(0L);
                        class104.field1689.method1419(var65.payload, var2, 24);
                     } catch (Exception var32) {
                        ;
                     }
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 102) {
               var17 = Client.field370.method3057();
               var2 = Client.field370.readUnsignedByte();
               var19 = Client.field370.method3018();
               if(var2 >= 1 && var2 <= 8) {
                  if(var17.equalsIgnoreCase("null")) {
                     var17 = null;
                  }

                  Client.field414[var2 - 1] = var17;
                  Client.field434[var2 - 1] = var19 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 2) {
               Client.field521 = Client.field370.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            WidgetNode var85;
            if(Client.packetOpcode == 18) {
               var1 = Client.field370.method3025();
               var2 = Client.field370.readUnsignedByte();
               var19 = Client.field370.method3036();
               var85 = (WidgetNode)Client.componentTable.method2405((long)var19);
               if(null != var85) {
                  XGrandExchangeOffer.method68(var85, var1 != var85.id);
               }

               WidgetNode var86 = new WidgetNode();
               var86.id = var1;
               var86.field174 = var2;
               Client.componentTable.method2406(var86, (long)var19);
               Client.method603(var1);
               Widget var45 = class5.method79(var19);
               Tile.method1577(var45);
               if(Client.field449 != null) {
                  Tile.method1577(Client.field449);
                  Client.field449 = null;
               }

               class162.method3195();
               class181.method3325(Widget.widgets[var19 >> 16], var45, false);
               class7.method103(var1);
               if(Client.widgetRoot != -1) {
                  XItemContainer.method181(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 188) {
               var1 = Client.field370.method2995();
               var2 = Client.field370.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var3 = class5.method79(var1);
               } else {
                  var3 = null;
               }

               for(; Client.field370.offset < Client.field564; class1.method19(var2, var4, var5 - 1, var20)) {
                  var4 = Client.field370.method3003();
                  var5 = Client.field370.readUnsignedShort();
                  var20 = 0;
                  if(var5 != 0) {
                     var20 = Client.field370.readUnsignedByte();
                     if(var20 == 255) {
                        var20 = Client.field370.method2995();
                     }
                  }

                  if(var3 != null && var4 >= 0 && var4 < var3.itemIds.length) {
                     var3.itemIds[var4] = var5;
                     var3.itemQuantities[var4] = var20;
                  }
               }

               if(null != var3) {
                  Tile.method1577(var3);
               }

               class182.method3405();
               Client.field473[++Client.field468 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 52) {
               var1 = Client.field370.method3067();
               class36.field772 = class15.field159.method1996(var1);
               Client.packetOpcode = -1;
               return true;
            }

            boolean var39;
            if(Client.packetOpcode == 13) {
               var39 = Client.field370.readUnsignedByte() == 1;
               if(var39) {
                  class2.field21 = class202.method3838() - Client.field370.method3118();
                  class3.field33 = new class1(Client.field370, true);
               } else {
                  class3.field33 = null;
               }

               Client.field481 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 100) {
               var1 = Client.field370.method3025();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               class36.method754(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 38) {
               var1 = Client.field370.readUnsignedShort();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field370.method3031();
               if(Client.field522 != 0 && var1 != -1) {
                  class119.method2349(Client.field332, var1, 0, Client.field522, false);
                  Client.field524 = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            int var9;
            int var13;
            int var14;
            int var15;
            String var27;
            String var91;
            if(Client.packetOpcode == 168) {
               var17 = Client.field370.method3057();
               class10.field91 = var17;

               try {
                  var27 = Client.field281.getParameter(class214.field3137.field3152);
                  var37 = Client.field281.getParameter(class214.field3150.field3152);
                  var91 = var27 + "settings=" + var17 + "; version=1; path=/; domain=" + var37;
                  if(var17.length() == 0) {
                     var91 = var91 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var84 = var91 + "; Expires=";
                     var59 = class202.method3838() + 94608000000L;
                     class169.field2343.setTime(new Date(var59));
                     var9 = class169.field2343.get(7);
                     var10 = class169.field2343.get(5);
                     var11 = class169.field2343.get(2);
                     var12 = class169.field2343.get(1);
                     var13 = class169.field2343.get(11);
                     var14 = class169.field2343.get(12);
                     var15 = class169.field2343.get(13);
                     String var44 = class169.field2344[var9 - 1] + ", " + var10 / 10 + var10 % 10 + "-" + class169.field2345[0][var11] + "-" + var12 + " " + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + ":" + var15 / 10 + var15 % 10 + " GMT";
                     var91 = var84 + var44 + "; Max-Age=" + 94608000L;
                  }

                  class100.method1979(Client.field281, "document.cookie=\"" + var91 + "\"");
               } catch (Throwable var31) {
                  ;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 54) {
               var17 = Client.field370.method3057();
               Object[] var101 = new Object[var17.length() + 1];

               for(var19 = var17.length() - 1; var19 >= 0; --var19) {
                  if(var17.charAt(var19) == 115) {
                     var101[1 + var19] = Client.field370.method3057();
                  } else {
                     var101[1 + var19] = new Integer(Client.field370.method2995());
                  }
               }

               var101[0] = new Integer(Client.field370.method2995());
               class18 var41 = new class18();
               var41.field196 = var101;
               class164.method3225(var41, 200000);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 19) {
               var17 = Client.field370.method3057();
               var2 = Client.field370.readUnsignedShort();
               byte var81 = Client.field370.method3047();
               var49 = false;
               if(var81 == -128) {
                  var49 = true;
               }

               if(var49) {
                  if(class60.field1072 == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  boolean var67 = false;

                  for(var5 = 0; var5 < class60.field1072 && (!class164.clanMembers[var5].username.equals(var17) || class164.clanMembers[var5].world != var2); ++var5) {
                     ;
                  }

                  if(var5 < class60.field1072) {
                     while(var5 < class60.field1072 - 1) {
                        class164.clanMembers[var5] = class164.clanMembers[1 + var5];
                        ++var5;
                     }

                     --class60.field1072;
                     class164.clanMembers[class60.field1072] = null;
                  }
               } else {
                  Client.field370.method3057();
                  XClanMember var83 = new XClanMember();
                  var83.username = var17;
                  var83.field277 = class162.method3194(var83.username, class108.field1740);
                  var83.world = var2;
                  var83.rank = var81;

                  for(var20 = class60.field1072 - 1; var20 >= 0; --var20) {
                     var7 = class164.clanMembers[var20].field277.compareTo(var83.field277);
                     if(var7 == 0) {
                        class164.clanMembers[var20].world = var2;
                        class164.clanMembers[var20].rank = var81;
                        if(var17.equals(class40.localPlayer.name)) {
                           WidgetNode.field175 = var81;
                        }

                        Client.field479 = Client.field470;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(class60.field1072 >= class164.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var7 = class60.field1072 - 1; var7 > var20; --var7) {
                     class164.clanMembers[1 + var7] = class164.clanMembers[var7];
                  }

                  if(class60.field1072 == 0) {
                     class164.clanMembers = new XClanMember[100];
                  }

                  class164.clanMembers[1 + var20] = var83;
                  ++class60.field1072;
                  if(var17.equals(class40.localPlayer.name)) {
                     WidgetNode.field175 = var81;
                  }
               }

               Client.field479 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 250) {
               var1 = Client.field370.method2995();
               WidgetNode var100 = (WidgetNode)Client.componentTable.method2405((long)var1);
               if(var100 != null) {
                  XGrandExchangeOffer.method68(var100, true);
               }

               if(null != Client.field449) {
                  Tile.method1577(Client.field449);
                  Client.field449 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var93;
            if(Client.packetOpcode == 142) {
               var1 = Client.field370.method3067();
               var93 = class5.method79(var1);

               for(var19 = 0; var19 < var93.itemIds.length; ++var19) {
                  var93.itemIds[var19] = -1;
                  var93.itemIds[var19] = 0;
               }

               Tile.method1577(var93);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 41) {
               Client.field364 = Client.field370.readUnsignedByte();
               Client.field504 = Client.field370.readUnsignedByte();
               Client.packetOpcode = -1;
               return true;
            }

            Player var6;
            int var16;
            byte[] var18;
            byte var26;
            Buffer var28;
            String var29;
            byte var52;
            boolean var57;
            class177 var63;
            if(Client.packetOpcode == 140) {
               var65 = Client.field370;
               var2 = Client.field564;
               var19 = var65.offset;
               class45.field908 = 0;
               var4 = 0;
               var65.method3232();

               for(var5 = 0; var5 < class45.field897; ++var5) {
                  var20 = class45.field902[var5];
                  if((class45.field898[var20] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var65.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var65);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else {
                           class1.method14(var65, var20);
                        }
                     }
                  }
               }

               var65.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var65.method3232();

               for(var5 = 0; var5 < class45.field897; ++var5) {
                  var20 = class45.field902[var5];
                  if((class45.field898[var20] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var65.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var65);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else {
                           class1.method14(var65, var20);
                        }
                     }
                  }
               }

               var65.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var65.method3232();

               for(var5 = 0; var5 < class45.field903; ++var5) {
                  var20 = class45.field904[var5];
                  if((class45.field898[var20] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var65.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var65);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else if(Item.method824(var65, var20)) {
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        }
                     }
                  }
               }

               var65.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var65.method3232();

               for(var5 = 0; var5 < class45.field903; ++var5) {
                  var20 = class45.field904[var5];
                  if((class45.field898[var20] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var65.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var65);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else if(Item.method824(var65, var20)) {
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        }
                     }
                  }
               }

               var65.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class45.field897 = 0;
               class45.field903 = 0;

               for(var5 = 1; var5 < 2048; ++var5) {
                  class45.field898[var5] = (byte)(class45.field898[var5] >> 1);
                  var6 = Client.cachedPlayers[var5];
                  if(null != var6) {
                     class45.field902[++class45.field897 - 1] = var5;
                  } else {
                     class45.field904[++class45.field903 - 1] = var5;
                  }
               }

               for(var4 = 0; var4 < class45.field908; ++var4) {
                  var5 = class45.field909[var4];
                  var6 = Client.cachedPlayers[var5];
                  var7 = var65.readUnsignedByte();
                  if((var7 & 64) != 0) {
                     var7 += var65.readUnsignedByte() << 8;
                  }

                  var26 = -1;
                  if((var7 & 32) != 0) {
                     var9 = var65.readUnsignedByte();
                     var18 = new byte[var9];
                     var28 = new Buffer(var18);
                     var65.method3043(var18, 0, var9);
                     class45.field900[var5] = var28;
                     var6.method230(var28);
                  }

                  if((var7 & 128) != 0) {
                     var9 = var65.readUnsignedShort();
                     if(var9 == '\uffff') {
                        var9 = -1;
                     }

                     var10 = var65.readUnsignedByte();
                     class36.method756(var6, var9, var10);
                  }

                  if((var7 & 8) != 0) {
                     var6.interacting = var65.readUnsignedShort();
                     if(var6.interacting == '\uffff') {
                        var6.interacting = -1;
                     }
                  }

                  if((var7 & 1) != 0) {
                     var6.overhead = var65.method3057();
                     if(var6.overhead.charAt(0) == 126) {
                        var6.overhead = var6.overhead.substring(1);
                        class10.method120(2, var6.name, var6.overhead);
                     } else if(class40.localPlayer == var6) {
                        class10.method120(2, var6.name, var6.overhead);
                     }

                     var6.field609 = false;
                     var6.field612 = 0;
                     var6.field613 = 0;
                     var6.field607 = 150;
                  }

                  if((var7 & 4) != 0) {
                     var9 = var65.readUnsignedByte();
                     if(var9 > 0) {
                        for(var10 = 0; var10 < var9; ++var10) {
                           var12 = -1;
                           var13 = -1;
                           var14 = -1;
                           var11 = var65.method3003();
                           if(var11 == 32767) {
                              var11 = var65.method3003();
                              var13 = var65.method3003();
                              var12 = var65.method3003();
                              var14 = var65.method3003();
                           } else if(var11 != 32766) {
                              var13 = var65.method3003();
                           } else {
                              var11 = -1;
                           }

                           var15 = var65.method3003();
                           var6.method624(var11, var13, var12, var14, Client.gameCycle, var15);
                        }
                     }

                     var10 = var65.readUnsignedByte();
                     if(var10 > 0) {
                        for(var11 = 0; var11 < var10; ++var11) {
                           var12 = var65.method3003();
                           var13 = var65.method3003();
                           if(var13 != 32767) {
                              var14 = var65.method3003();
                              var15 = var65.readUnsignedByte();
                              var16 = var13 > 0?var65.readUnsignedByte():var15;
                              var6.method620(var12, Client.gameCycle, var13, var14, var15, var16);
                           } else {
                              var6.method621(var12);
                           }
                        }
                     }
                  }

                  if((var7 & 16) != 0) {
                     var6.field623 = var65.readUnsignedShort();
                     if(var6.field649 == 0) {
                        var6.field646 = var6.field623;
                        var6.field623 = -1;
                     }
                  }

                  if((var7 & 2) != 0) {
                     var9 = var65.readUnsignedShort();
                     var63 = (class177)class101.method1985(class65.method1170(), var65.readUnsignedByte());
                     var55 = var65.readUnsignedByte() == 1;
                     var12 = var65.readUnsignedByte();
                     var13 = var65.offset;
                     if(var6.name != null && null != var6.composition) {
                        var57 = false;
                        if(var63.field2673 && class186.method3472(var6.name)) {
                           var57 = true;
                        }

                        if(!var57 && Client.field366 == 0 && !var6.field263) {
                           class45.field899.offset = 0;
                           var65.method3043(class45.field899.payload, 0, var12);
                           class45.field899.offset = 0;
                           var29 = class209.method3979(PlayerComposition.method2823(class159.method2973(class45.field899)));
                           var6.overhead = var29.trim();
                           var6.field612 = var9 >> 8;
                           var6.field613 = var9 & 255;
                           var6.field607 = 150;
                           var6.field609 = var55;
                           var6.inSequence = class40.localPlayer != var6 && var63.field2673 && "" != Client.field505 && var29.toLowerCase().indexOf(Client.field505) == -1;
                           if(var63.field2674) {
                              var16 = var55?91:1;
                           } else {
                              var16 = var55?90:2;
                           }

                           if(var63.field2677 != -1) {
                              class10.method120(var16, class9.method116(var63.field2677) + var6.name, var29);
                           } else {
                              class10.method120(var16, var6.name, var29);
                           }
                        }
                     }

                     var65.offset = var12 + var13;
                  }

                  if((var7 & 4096) != 0) {
                     var6.graphic = var65.readUnsignedShort();
                     var9 = var65.method2995();
                     var6.field636 = var9 >> 16;
                     var6.field608 = Client.gameCycle + (var9 & '\uffff');
                     var6.field633 = 0;
                     var6.field616 = 0;
                     if(var6.field608 > Client.gameCycle) {
                        var6.field633 = -1;
                     }

                     if(var6.graphic == '\uffff') {
                        var6.graphic = -1;
                     }
                  }

                  if((var7 & 2048) != 0) {
                     var6.field637 = var65.method3047();
                     var6.field639 = var65.method3047();
                     var6.field638 = var65.method3047();
                     var6.field640 = var65.method3047();
                     var6.field648 = var65.readUnsignedShort() + Client.gameCycle;
                     var6.field642 = var65.readUnsignedShort() + Client.gameCycle;
                     var6.field643 = var65.readUnsignedShort();
                     if(var6.field264) {
                        var6.field637 += var6.field247;
                        var6.field639 += var6.field268;
                        var6.field638 += var6.field247;
                        var6.field640 += var6.field268;
                        var6.field649 = 0;
                     } else {
                        var6.field637 += var6.pathX[0];
                        var6.field639 += var6.pathY[0];
                        var6.field638 += var6.pathX[0];
                        var6.field640 += var6.pathY[0];
                        var6.field649 = 1;
                     }

                     var6.field654 = 0;
                  }

                  if((var7 & 1024) != 0) {
                     class45.field901[var5] = var65.method3047();
                  }

                  if((var7 & 256) != 0) {
                     var26 = var65.method3047();
                  }

                  if((var7 & 512) != 0) {
                     for(var9 = 0; var9 < 3; ++var9) {
                        var6.actions[var9] = var65.method3057();
                     }
                  }

                  if(var6.field264) {
                     if(var26 == 127) {
                        var6.method234(var6.field247, var6.field268);
                     } else {
                        if(var26 != -1) {
                           var52 = var26;
                        } else {
                           var52 = class45.field901[var5];
                        }

                        var6.method233(var6.field247, var6.field268, var52);
                     }
                  }
               }

               if(var2 != var65.offset - var19) {
                  throw new RuntimeException(var65.offset - var19 + " " + var2);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 116) {
               var17 = Client.field370.method3057();
               var27 = class209.method3979(PlayerComposition.method2823(class159.method2973(Client.field370)));
               class10.method120(6, var17, var27);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 207) {
               while(Client.field370.offset < Client.field564) {
                  var1 = Client.field370.readUnsignedByte();
                  var50 = (var1 & 1) == 1;
                  var37 = Client.field370.method3057();
                  var91 = Client.field370.method3057();
                  Client.field370.method3057();

                  for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                     Ignore var42 = Client.ignores[var5];
                     if(var50) {
                        if(var91.equals(var42.name)) {
                           var42.name = var37;
                           var42.previousName = var91;
                           var37 = null;
                           break;
                        }
                     } else if(var37.equals(var42.name)) {
                        var42.name = var37;
                        var42.previousName = var91;
                        var37 = null;
                        break;
                     }
                  }

                  if(null != var37 && Client.ignoreCount < 400) {
                     Ignore var82 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var82;
                     var82.name = var37;
                     var82.previousName = var91;
                     ++Client.ignoreCount;
                  }
               }

               Client.field388 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 67) {
               var1 = Client.field370.method2995();
               var2 = Client.field370.readUnsignedShort();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var3 = class5.method79(var1);
               } else {
                  var3 = null;
               }

               if(null != var3) {
                  for(var4 = 0; var4 < var3.itemIds.length; ++var4) {
                     var3.itemIds[var4] = 0;
                     var3.itemQuantities[var4] = 0;
                  }
               }

               class49.method898(var2);
               var4 = Client.field370.readUnsignedShort();

               for(var5 = 0; var5 < var4; ++var5) {
                  var20 = Client.field370.method3026();
                  var7 = Client.field370.readUnsignedByte();
                  if(var7 == 255) {
                     var7 = Client.field370.method3036();
                  }

                  if(null != var3 && var5 < var3.itemIds.length) {
                     var3.itemIds[var5] = var20;
                     var3.itemQuantities[var5] = var7;
                  }

                  class1.method19(var2, var5, var20 - 1, var7);
               }

               if(null != var3) {
                  Tile.method1577(var3);
               }

               class182.method3405();
               Client.field473[++Client.field468 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 158) {
               for(var1 = 0; var1 < class187.field2773; ++var1) {
                  class187 var99 = class179.method3314(var1);
                  if(null != var99) {
                     class146.settings[var1] = 0;
                     class146.widgetSettings[var1] = 0;
                  }
               }

               class182.method3405();
               Client.field472 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 191) {
               class3.field32 = Client.field370.method3019();
               class7.field65 = Client.field370.readUnsignedByte();

               while(Client.field370.offset < Client.field564) {
                  Client.packetOpcode = Client.field370.readUnsignedByte();
                  class13.method183();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 11) {
               GameEngine.method2223();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 186) {
               var1 = Client.field370.readUnsignedShort();
               var2 = Client.field370.readUnsignedByte();
               var19 = Client.field370.readUnsignedShort();
               if(Client.field478 != 0 && var2 != 0 && Client.field527 < 50) {
                  Client.field528[Client.field527] = var1;
                  Client.field529[Client.field527] = var2;
                  Client.field431[Client.field527] = var19;
                  Client.field532[Client.field527] = null;
                  Client.field299[Client.field527] = 0;
                  ++Client.field527;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 28) {
               var1 = Client.field370.method3036();
               var2 = Client.field370.method3028();
               var3 = class5.method79(var1);
               if(var3.field2116 != var2 || var2 == -1) {
                  var3.field2116 = var2;
                  var3.field2057 = 0;
                  var3.field2192 = 0;
                  Tile.method1577(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 78) {
               class13.method188(Client.field370, Client.field564);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 134) {
               var1 = Client.field370.method2995();
               var2 = Client.field370.method2995();
               if(null == class101.field1651 || !class101.field1651.isValid()) {
                  try {
                     Iterator var38 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var38.hasNext()) {
                        GarbageCollectorMXBean var89 = (GarbageCollectorMXBean)var38.next();
                        if(var89.isValid()) {
                           class101.field1651 = var89;
                           Client.field513 = -1L;
                           Client.field562 = -1L;
                        }
                     }
                  } catch (Throwable var33) {
                     ;
                  }
               }

               long var71 = class202.method3838();
               var5 = -1;
               if(class101.field1651 != null) {
                  var72 = class101.field1651.getCollectionTime();
                  if(Client.field562 != -1L) {
                     long var98 = var72 - Client.field562;
                     var53 = var71 - Client.field513;
                     if(0L != var53) {
                        var5 = (int)(var98 * 100L / var53);
                     }
                  }

                  Client.field562 = var72;
                  Client.field513 = var71;
               }

               Client.field330.method3234(185);
               Client.field330.method2986(GameEngine.field1775);
               Client.field330.method2978(var1);
               Client.field330.method3011(var2);
               Client.field330.method2986(var5);
               Client.packetOpcode = -1;
               return true;
            }

            class166 var97;
            if(Client.packetOpcode == 244) {
               class9.xteaChanged(true);
               Client.field370.method3235();
               var1 = Client.field370.readUnsignedShort();
               var97 = Client.field370;
               var19 = var97.offset;
               class45.field908 = 0;
               var4 = 0;
               var97.method3232();

               for(var5 = 0; var5 < class45.field897; ++var5) {
                  var20 = class45.field902[var5];
                  if((class45.field898[var20] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else {
                           class1.method14(var97, var20);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var97.method3232();

               for(var5 = 0; var5 < class45.field897; ++var5) {
                  var20 = class45.field902[var5];
                  if((class45.field898[var20] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else {
                           class1.method14(var97, var20);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var97.method3232();

               for(var5 = 0; var5 < class45.field903; ++var5) {
                  var20 = class45.field904[var5];
                  if((class45.field898[var20] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else if(Item.method824(var97, var20)) {
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var97.method3232();

               for(var5 = 0; var5 < class45.field903; ++var5) {
                  var20 = class45.field904[var5];
                  if((class45.field898[var20] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else if(Item.method824(var97, var20)) {
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class45.field897 = 0;
               class45.field903 = 0;

               for(var5 = 1; var5 < 2048; ++var5) {
                  class45.field898[var5] = (byte)(class45.field898[var5] >> 1);
                  var6 = Client.cachedPlayers[var5];
                  if(var6 != null) {
                     class45.field902[++class45.field897 - 1] = var5;
                  } else {
                     class45.field904[++class45.field903 - 1] = var5;
                  }
               }

               for(var4 = 0; var4 < class45.field908; ++var4) {
                  var5 = class45.field909[var4];
                  var6 = Client.cachedPlayers[var5];
                  var7 = var97.readUnsignedByte();
                  if((var7 & 64) != 0) {
                     var7 += var97.readUnsignedByte() << 8;
                  }

                  var26 = -1;
                  if((var7 & 32) != 0) {
                     var9 = var97.readUnsignedByte();
                     var18 = new byte[var9];
                     var28 = new Buffer(var18);
                     var97.method3043(var18, 0, var9);
                     class45.field900[var5] = var28;
                     var6.method230(var28);
                  }

                  if((var7 & 128) != 0) {
                     var9 = var97.readUnsignedShort();
                     if(var9 == '\uffff') {
                        var9 = -1;
                     }

                     var10 = var97.readUnsignedByte();
                     class36.method756(var6, var9, var10);
                  }

                  if((var7 & 8) != 0) {
                     var6.interacting = var97.readUnsignedShort();
                     if(var6.interacting == '\uffff') {
                        var6.interacting = -1;
                     }
                  }

                  if((var7 & 1) != 0) {
                     var6.overhead = var97.method3057();
                     if(var6.overhead.charAt(0) == 126) {
                        var6.overhead = var6.overhead.substring(1);
                        class10.method120(2, var6.name, var6.overhead);
                     } else if(class40.localPlayer == var6) {
                        class10.method120(2, var6.name, var6.overhead);
                     }

                     var6.field609 = false;
                     var6.field612 = 0;
                     var6.field613 = 0;
                     var6.field607 = 150;
                  }

                  if((var7 & 4) != 0) {
                     var9 = var97.readUnsignedByte();
                     if(var9 > 0) {
                        for(var10 = 0; var10 < var9; ++var10) {
                           var12 = -1;
                           var13 = -1;
                           var14 = -1;
                           var11 = var97.method3003();
                           if(var11 == 32767) {
                              var11 = var97.method3003();
                              var13 = var97.method3003();
                              var12 = var97.method3003();
                              var14 = var97.method3003();
                           } else if(var11 != 32766) {
                              var13 = var97.method3003();
                           } else {
                              var11 = -1;
                           }

                           var15 = var97.method3003();
                           var6.method624(var11, var13, var12, var14, Client.gameCycle, var15);
                        }
                     }

                     var10 = var97.readUnsignedByte();
                     if(var10 > 0) {
                        for(var11 = 0; var11 < var10; ++var11) {
                           var12 = var97.method3003();
                           var13 = var97.method3003();
                           if(var13 != 32767) {
                              var14 = var97.method3003();
                              var15 = var97.readUnsignedByte();
                              var16 = var13 > 0?var97.readUnsignedByte():var15;
                              var6.method620(var12, Client.gameCycle, var13, var14, var15, var16);
                           } else {
                              var6.method621(var12);
                           }
                        }
                     }
                  }

                  if((var7 & 16) != 0) {
                     var6.field623 = var97.readUnsignedShort();
                     if(var6.field649 == 0) {
                        var6.field646 = var6.field623;
                        var6.field623 = -1;
                     }
                  }

                  if((var7 & 2) != 0) {
                     var9 = var97.readUnsignedShort();
                     var63 = (class177)class101.method1985(class65.method1170(), var97.readUnsignedByte());
                     var55 = var97.readUnsignedByte() == 1;
                     var12 = var97.readUnsignedByte();
                     var13 = var97.offset;
                     if(var6.name != null && null != var6.composition) {
                        var57 = false;
                        if(var63.field2673 && class186.method3472(var6.name)) {
                           var57 = true;
                        }

                        if(!var57 && Client.field366 == 0 && !var6.field263) {
                           class45.field899.offset = 0;
                           var97.method3043(class45.field899.payload, 0, var12);
                           class45.field899.offset = 0;
                           var29 = class209.method3979(PlayerComposition.method2823(class159.method2973(class45.field899)));
                           var6.overhead = var29.trim();
                           var6.field612 = var9 >> 8;
                           var6.field613 = var9 & 255;
                           var6.field607 = 150;
                           var6.field609 = var55;
                           var6.inSequence = class40.localPlayer != var6 && var63.field2673 && "" != Client.field505 && var29.toLowerCase().indexOf(Client.field505) == -1;
                           if(var63.field2674) {
                              var16 = var55?91:1;
                           } else {
                              var16 = var55?90:2;
                           }

                           if(var63.field2677 != -1) {
                              class10.method120(var16, class9.method116(var63.field2677) + var6.name, var29);
                           } else {
                              class10.method120(var16, var6.name, var29);
                           }
                        }
                     }

                     var97.offset = var13 + var12;
                  }

                  if((var7 & 4096) != 0) {
                     var6.graphic = var97.readUnsignedShort();
                     var9 = var97.method2995();
                     var6.field636 = var9 >> 16;
                     var6.field608 = (var9 & '\uffff') + Client.gameCycle;
                     var6.field633 = 0;
                     var6.field616 = 0;
                     if(var6.field608 > Client.gameCycle) {
                        var6.field633 = -1;
                     }

                     if(var6.graphic == '\uffff') {
                        var6.graphic = -1;
                     }
                  }

                  if((var7 & 2048) != 0) {
                     var6.field637 = var97.method3047();
                     var6.field639 = var97.method3047();
                     var6.field638 = var97.method3047();
                     var6.field640 = var97.method3047();
                     var6.field648 = var97.readUnsignedShort() + Client.gameCycle;
                     var6.field642 = var97.readUnsignedShort() + Client.gameCycle;
                     var6.field643 = var97.readUnsignedShort();
                     if(var6.field264) {
                        var6.field637 += var6.field247;
                        var6.field639 += var6.field268;
                        var6.field638 += var6.field247;
                        var6.field640 += var6.field268;
                        var6.field649 = 0;
                     } else {
                        var6.field637 += var6.pathX[0];
                        var6.field639 += var6.pathY[0];
                        var6.field638 += var6.pathX[0];
                        var6.field640 += var6.pathY[0];
                        var6.field649 = 1;
                     }

                     var6.field654 = 0;
                  }

                  if((var7 & 1024) != 0) {
                     class45.field901[var5] = var97.method3047();
                  }

                  if((var7 & 256) != 0) {
                     var26 = var97.method3047();
                  }

                  if((var7 & 512) != 0) {
                     for(var9 = 0; var9 < 3; ++var9) {
                        var6.actions[var9] = var97.method3057();
                     }
                  }

                  if(var6.field264) {
                     if(var26 == 127) {
                        var6.method234(var6.field247, var6.field268);
                     } else {
                        if(var26 != -1) {
                           var52 = var26;
                        } else {
                           var52 = class45.field901[var5];
                        }

                        var6.method233(var6.field247, var6.field268, var52);
                     }
                  }
               }

               if(var1 != var97.offset - var19) {
                  throw new RuntimeException(var97.offset - var19 + " " + var1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 49) {
               while(Client.field370.offset < Client.field564) {
                  var39 = Client.field370.readUnsignedByte() == 1;
                  var27 = Client.field370.method3057();
                  var37 = Client.field370.method3057();
                  var4 = Client.field370.readUnsignedShort();
                  var5 = Client.field370.readUnsignedByte();
                  var20 = Client.field370.readUnsignedByte();
                  boolean var48 = (var20 & 2) != 0;
                  var94 = (var20 & 1) != 0;
                  if(var4 > 0) {
                     Client.field370.method3057();
                     Client.field370.readUnsignedByte();
                     Client.field370.method2995();
                  }

                  Client.field370.method3057();

                  for(var9 = 0; var9 < Client.friendCount; ++var9) {
                     Friend var66 = Client.friends[var9];
                     if(!var39) {
                        if(var27.equals(var66.name)) {
                           if(var66.world != var4) {
                              var55 = true;

                              for(class16 var23 = (class16)Client.field555.method2489(); null != var23; var23 = (class16)Client.field555.method2488()) {
                                 if(var23.field163.equals(var27)) {
                                    if(var4 != 0 && var23.field162 == 0) {
                                       var23.method2501();
                                       var55 = false;
                                    } else if(var4 == 0 && var23.field162 != 0) {
                                       var23.method2501();
                                       var55 = false;
                                    }
                                 }
                              }

                              if(var55) {
                                 Client.field555.method2487(new class16(var27, var4));
                              }

                              var66.world = var4;
                           }

                           var66.previousName = var37;
                           var66.rank = var5;
                           var66.field151 = var48;
                           var66.field148 = var94;
                           var27 = null;
                           break;
                        }
                     } else if(var37.equals(var66.name)) {
                        var66.name = var27;
                        var66.previousName = var37;
                        var27 = null;
                        break;
                     }
                  }

                  if(null != var27 && Client.friendCount < 400) {
                     Friend var87 = new Friend();
                     Client.friends[Client.friendCount] = var87;
                     var87.name = var27;
                     var87.previousName = var37;
                     var87.world = var4;
                     var87.rank = var5;
                     var87.field151 = var48;
                     var87.field148 = var94;
                     ++Client.friendCount;
                  }
               }

               Client.field553 = 2;
               Client.field388 = Client.field470;
               var39 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var39 = true;
                  --var2;

                  for(var19 = 0; var19 < var2; ++var19) {
                     var49 = false;
                     Friend var79 = Client.friends[var19];
                     Friend var40 = Client.friends[1 + var19];
                     if(var79.world != Client.world && var40.world == Client.world) {
                        var49 = true;
                     }

                     if(!var49 && var79.world == 0 && var40.world != 0) {
                        var49 = true;
                     }

                     if(!var49 && !var79.field151 && var40.field151) {
                        var49 = true;
                     }

                     if(!var49 && !var79.field148 && var40.field148) {
                        var49 = true;
                     }

                     if(var49) {
                        Friend var75 = Client.friends[var19];
                        Client.friends[var19] = Client.friends[var19 + 1];
                        Client.friends[1 + var19] = var75;
                        var39 = false;
                     }
                  }

                  if(var39) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 180) {
               var1 = Client.field370.method3029();
               var2 = Client.field370.method2993();
               var19 = Client.field370.method2995();
               var24 = class5.method79(var19);
               if(var24.field2078 != var1 || var2 != var24.field2087 || var24.field2074 != 0 || var24.field2075 != 0) {
                  var24.field2078 = var1;
                  var24.field2087 = var2;
                  var24.field2074 = 0;
                  var24.field2075 = 0;
                  Tile.method1577(var24);
                  class2.method32(var24);
                  if(var24.type == 0) {
                     class181.method3325(Widget.widgets[var19 >> 16], var24, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 69) {
               Client.field301 = Client.field370.method3026() * 30;
               Client.field379 = Client.field470;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 237) {
               World var62 = new World();
               var62.address = Client.field370.method3057();
               var62.id = Client.field370.readUnsignedShort();
               var2 = Client.field370.method2995();
               var62.mask = var2;
               class186.setGameState(45);
               FileOnDisk.field1183.method2121();
               FileOnDisk.field1183 = null;
               Projectile.selectWorld(var62);
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 144) {
               var1 = Client.field370.method3025();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field370.method3025();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var19 = Client.field370.method2995();
               var4 = Client.field370.method3036();

               for(var5 = var1; var5 <= var2; ++var5) {
                  var72 = (long)var5 + ((long)var4 << 32);
                  Node var8 = Client.widgetFlags.method2405(var72);
                  if(var8 != null) {
                     var8.unlink();
                  }

                  Client.widgetFlags.method2406(new class133(var19), var72);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 149) {
               var1 = Client.field564 + Client.field370.offset;
               var2 = Client.field370.readUnsignedShort();
               var19 = Client.field370.readUnsignedShort();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  class101.method1990(Client.widgetRoot, class16.field169, class65.field1103, false);
                  Client.method603(Client.widgetRoot);
                  class7.method103(Client.widgetRoot);

                  for(var4 = 0; var4 < 100; ++var4) {
                     Client.field490[var4] = true;
                  }
               }

               WidgetNode var21;
               for(; var19-- > 0; var21.field173 = true) {
                  var4 = Client.field370.method2995();
                  var5 = Client.field370.readUnsignedShort();
                  var20 = Client.field370.readUnsignedByte();
                  var21 = (WidgetNode)Client.componentTable.method2405((long)var4);
                  if(null != var21 && var5 != var21.id) {
                     XGrandExchangeOffer.method68(var21, true);
                     var21 = null;
                  }

                  if(var21 == null) {
                     WidgetNode var25 = new WidgetNode();
                     var25.id = var5;
                     var25.field174 = var20;
                     Client.componentTable.method2406(var25, (long)var4);
                     Client.method603(var5);
                     Widget var64 = class5.method79(var4);
                     Tile.method1577(var64);
                     if(null != Client.field449) {
                        Tile.method1577(Client.field449);
                        Client.field449 = null;
                     }

                     class162.method3195();
                     class181.method3325(Widget.widgets[var4 >> 16], var64, false);
                     class7.method103(var5);
                     if(Client.widgetRoot != -1) {
                        XItemContainer.method181(Client.widgetRoot, 1);
                     }

                     var21 = var25;
                  }
               }

               for(var85 = (WidgetNode)Client.componentTable.method2414(); var85 != null; var85 = (WidgetNode)Client.componentTable.method2409()) {
                  if(var85.field173) {
                     var85.field173 = false;
                  } else {
                     XGrandExchangeOffer.method68(var85, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field370.offset < var1) {
                  var4 = Client.field370.method2995();
                  var5 = Client.field370.readUnsignedShort();
                  var20 = Client.field370.readUnsignedShort();
                  var7 = Client.field370.method2995();

                  for(var92 = var5; var92 <= var20; ++var92) {
                     var54 = (long)var92 + ((long)var4 << 32);
                     Client.widgetFlags.method2406(new class133(var7), var54);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 40) {
               var1 = Client.field370.method3036();
               var2 = Client.field370.method2995();
               WidgetNode var36 = (WidgetNode)Client.componentTable.method2405((long)var2);
               var85 = (WidgetNode)Client.componentTable.method2405((long)var1);
               if(var85 != null) {
                  XGrandExchangeOffer.method68(var85, null == var36 || var36.id != var85.id);
               }

               if(null != var36) {
                  var36.unlink();
                  Client.componentTable.method2406(var36, (long)var1);
               }

               var74 = class5.method79(var2);
               if(var74 != null) {
                  Tile.method1577(var74);
               }

               var74 = class5.method79(var1);
               if(var74 != null) {
                  Tile.method1577(var74);
                  class181.method3325(Widget.widgets[var74.id >>> 16], var74, true);
               }

               if(Client.widgetRoot != -1) {
                  XItemContainer.method181(Client.widgetRoot, 1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 238) {
               class3.field32 = Client.field370.readUnsignedByte();
               class7.field65 = Client.field370.readUnsignedByte();

               for(var1 = class7.field65; var1 < 8 + class7.field65; ++var1) {
                  for(var2 = class3.field32; var2 < class3.field32 + 8; ++var2) {
                     if(Client.groundItemDeque[class166.plane][var1][var2] != null) {
                        Client.groundItemDeque[class166.plane][var1][var2] = null;
                        ChatLineBuffer.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class25 var60 = (class25)Client.field419.method2466(); null != var60; var60 = (class25)Client.field419.method2461()) {
                  if(var60.field578 >= class7.field65 && var60.field578 < class7.field65 + 8 && var60.field574 >= class3.field32 && var60.field574 < 8 + class3.field32 && class166.plane == var60.field573) {
                     var60.field582 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 101) {
               var1 = Client.field370.method3037();
               var2 = Client.field370.method3153();
               var3 = class5.method79(var1);
               if(var3.modelType != 1 || var3.modelId != var2) {
                  var3.modelType = 1;
                  var3.modelId = var2;
                  Tile.method1577(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 22) {
               Client.field302 = Client.field370.readUnsignedByte();
               if(Client.field302 == 1) {
                  Client.field303 = Client.field370.readUnsignedShort();
               }

               if(Client.field302 >= 2 && Client.field302 <= 6) {
                  if(Client.field302 == 2) {
                     Client.field308 = 64;
                     Client.field309 = 64;
                  }

                  if(Client.field302 == 3) {
                     Client.field308 = 0;
                     Client.field309 = 64;
                  }

                  if(Client.field302 == 4) {
                     Client.field308 = 128;
                     Client.field309 = 64;
                  }

                  if(Client.field302 == 5) {
                     Client.field308 = 64;
                     Client.field309 = 0;
                  }

                  if(Client.field302 == 6) {
                     Client.field308 = 64;
                     Client.field309 = 128;
                  }

                  Client.field302 = 2;
                  Client.field305 = Client.field370.readUnsignedShort();
                  Client.field306 = Client.field370.readUnsignedShort();
                  Client.field453 = Client.field370.readUnsignedByte();
               }

               if(Client.field302 == 10) {
                  Client.field304 = Client.field370.readUnsignedShort();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 182) {
               class9.xteaChanged(false);
               Client.field370.method3235();
               var1 = Client.field370.readUnsignedShort();
               var97 = Client.field370;
               var19 = var97.offset;
               class45.field908 = 0;
               var4 = 0;
               var97.method3232();

               for(var5 = 0; var5 < class45.field897; ++var5) {
                  var20 = class45.field902[var5];
                  if((class45.field898[var20] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else {
                           class1.method14(var97, var20);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var97.method3232();

               for(var5 = 0; var5 < class45.field897; ++var5) {
                  var20 = class45.field902[var5];
                  if((class45.field898[var20] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else {
                           class1.method14(var97, var20);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var97.method3232();

               for(var5 = 0; var5 < class45.field903; ++var5) {
                  var20 = class45.field904[var5];
                  if((class45.field898[var20] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else if(Item.method824(var97, var20)) {
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var97.method3232();

               for(var5 = 0; var5 < class45.field903; ++var5) {
                  var20 = class45.field904[var5];
                  if((class45.field898[var20] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                     } else {
                        var7 = var97.method3237(1);
                        if(var7 == 0) {
                           var4 = class180.method3324(var97);
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        } else if(Item.method824(var97, var20)) {
                           class45.field898[var20] = (byte)(class45.field898[var20] | 2);
                        }
                     }
                  }
               }

               var97.method3238();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class45.field897 = 0;
               class45.field903 = 0;

               for(var5 = 1; var5 < 2048; ++var5) {
                  class45.field898[var5] = (byte)(class45.field898[var5] >> 1);
                  var6 = Client.cachedPlayers[var5];
                  if(null != var6) {
                     class45.field902[++class45.field897 - 1] = var5;
                  } else {
                     class45.field904[++class45.field903 - 1] = var5;
                  }
               }

               for(var4 = 0; var4 < class45.field908; ++var4) {
                  var5 = class45.field909[var4];
                  var6 = Client.cachedPlayers[var5];
                  var7 = var97.readUnsignedByte();
                  if((var7 & 64) != 0) {
                     var7 += var97.readUnsignedByte() << 8;
                  }

                  var26 = -1;
                  if((var7 & 32) != 0) {
                     var9 = var97.readUnsignedByte();
                     var18 = new byte[var9];
                     var28 = new Buffer(var18);
                     var97.method3043(var18, 0, var9);
                     class45.field900[var5] = var28;
                     var6.method230(var28);
                  }

                  if((var7 & 128) != 0) {
                     var9 = var97.readUnsignedShort();
                     if(var9 == '\uffff') {
                        var9 = -1;
                     }

                     var10 = var97.readUnsignedByte();
                     class36.method756(var6, var9, var10);
                  }

                  if((var7 & 8) != 0) {
                     var6.interacting = var97.readUnsignedShort();
                     if(var6.interacting == '\uffff') {
                        var6.interacting = -1;
                     }
                  }

                  if((var7 & 1) != 0) {
                     var6.overhead = var97.method3057();
                     if(var6.overhead.charAt(0) == 126) {
                        var6.overhead = var6.overhead.substring(1);
                        class10.method120(2, var6.name, var6.overhead);
                     } else if(class40.localPlayer == var6) {
                        class10.method120(2, var6.name, var6.overhead);
                     }

                     var6.field609 = false;
                     var6.field612 = 0;
                     var6.field613 = 0;
                     var6.field607 = 150;
                  }

                  if((var7 & 4) != 0) {
                     var9 = var97.readUnsignedByte();
                     if(var9 > 0) {
                        for(var10 = 0; var10 < var9; ++var10) {
                           var12 = -1;
                           var13 = -1;
                           var14 = -1;
                           var11 = var97.method3003();
                           if(var11 == 32767) {
                              var11 = var97.method3003();
                              var13 = var97.method3003();
                              var12 = var97.method3003();
                              var14 = var97.method3003();
                           } else if(var11 != 32766) {
                              var13 = var97.method3003();
                           } else {
                              var11 = -1;
                           }

                           var15 = var97.method3003();
                           var6.method624(var11, var13, var12, var14, Client.gameCycle, var15);
                        }
                     }

                     var10 = var97.readUnsignedByte();
                     if(var10 > 0) {
                        for(var11 = 0; var11 < var10; ++var11) {
                           var12 = var97.method3003();
                           var13 = var97.method3003();
                           if(var13 != 32767) {
                              var14 = var97.method3003();
                              var15 = var97.readUnsignedByte();
                              var16 = var13 > 0?var97.readUnsignedByte():var15;
                              var6.method620(var12, Client.gameCycle, var13, var14, var15, var16);
                           } else {
                              var6.method621(var12);
                           }
                        }
                     }
                  }

                  if((var7 & 16) != 0) {
                     var6.field623 = var97.readUnsignedShort();
                     if(var6.field649 == 0) {
                        var6.field646 = var6.field623;
                        var6.field623 = -1;
                     }
                  }

                  if((var7 & 2) != 0) {
                     var9 = var97.readUnsignedShort();
                     var63 = (class177)class101.method1985(class65.method1170(), var97.readUnsignedByte());
                     var55 = var97.readUnsignedByte() == 1;
                     var12 = var97.readUnsignedByte();
                     var13 = var97.offset;
                     if(null != var6.name && null != var6.composition) {
                        var57 = false;
                        if(var63.field2673 && class186.method3472(var6.name)) {
                           var57 = true;
                        }

                        if(!var57 && Client.field366 == 0 && !var6.field263) {
                           class45.field899.offset = 0;
                           var97.method3043(class45.field899.payload, 0, var12);
                           class45.field899.offset = 0;
                           var29 = class209.method3979(PlayerComposition.method2823(class159.method2973(class45.field899)));
                           var6.overhead = var29.trim();
                           var6.field612 = var9 >> 8;
                           var6.field613 = var9 & 255;
                           var6.field607 = 150;
                           var6.field609 = var55;
                           var6.inSequence = var6 != class40.localPlayer && var63.field2673 && Client.field505 != "" && var29.toLowerCase().indexOf(Client.field505) == -1;
                           if(var63.field2674) {
                              var16 = var55?91:1;
                           } else {
                              var16 = var55?90:2;
                           }

                           if(var63.field2677 != -1) {
                              class10.method120(var16, class9.method116(var63.field2677) + var6.name, var29);
                           } else {
                              class10.method120(var16, var6.name, var29);
                           }
                        }
                     }

                     var97.offset = var12 + var13;
                  }

                  if((var7 & 4096) != 0) {
                     var6.graphic = var97.readUnsignedShort();
                     var9 = var97.method2995();
                     var6.field636 = var9 >> 16;
                     var6.field608 = (var9 & '\uffff') + Client.gameCycle;
                     var6.field633 = 0;
                     var6.field616 = 0;
                     if(var6.field608 > Client.gameCycle) {
                        var6.field633 = -1;
                     }

                     if(var6.graphic == '\uffff') {
                        var6.graphic = -1;
                     }
                  }

                  if((var7 & 2048) != 0) {
                     var6.field637 = var97.method3047();
                     var6.field639 = var97.method3047();
                     var6.field638 = var97.method3047();
                     var6.field640 = var97.method3047();
                     var6.field648 = var97.readUnsignedShort() + Client.gameCycle;
                     var6.field642 = var97.readUnsignedShort() + Client.gameCycle;
                     var6.field643 = var97.readUnsignedShort();
                     if(var6.field264) {
                        var6.field637 += var6.field247;
                        var6.field639 += var6.field268;
                        var6.field638 += var6.field247;
                        var6.field640 += var6.field268;
                        var6.field649 = 0;
                     } else {
                        var6.field637 += var6.pathX[0];
                        var6.field639 += var6.pathY[0];
                        var6.field638 += var6.pathX[0];
                        var6.field640 += var6.pathY[0];
                        var6.field649 = 1;
                     }

                     var6.field654 = 0;
                  }

                  if((var7 & 1024) != 0) {
                     class45.field901[var5] = var97.method3047();
                  }

                  if((var7 & 256) != 0) {
                     var26 = var97.method3047();
                  }

                  if((var7 & 512) != 0) {
                     for(var9 = 0; var9 < 3; ++var9) {
                        var6.actions[var9] = var97.method3057();
                     }
                  }

                  if(var6.field264) {
                     if(var26 == 127) {
                        var6.method234(var6.field247, var6.field268);
                     } else {
                        if(var26 != -1) {
                           var52 = var26;
                        } else {
                           var52 = class45.field901[var5];
                        }

                        var6.method233(var6.field247, var6.field268, var52);
                     }
                  }
               }

               if(var1 != var97.offset - var19) {
                  throw new RuntimeException(var97.offset - var19 + " " + var1);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 145) {
               var1 = Client.field370.method3026();
               XItemContainer var95 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var1);
               if(null != var95) {
                  var95.unlink();
               }

               Client.field473[++Client.field468 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 234) {
               var1 = Client.field370.method3067();
               var93 = class5.method79(var1);
               var93.modelType = 3;
               var93.modelId = class40.localPlayer.composition.method2801();
               Tile.method1577(var93);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 187) {
               var1 = Client.field370.method3067();
               var2 = Client.field370.method3025();
               class146.settings[var2] = var1;
               if(var1 != class146.widgetSettings[var2]) {
                  class146.widgetSettings[var2] = var1;
               }

               class41.method801(var2);
               Client.field400[++Client.field472 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 172) {
               var1 = Client.field370.method3036();
               var27 = Client.field370.method3057();
               var3 = class5.method79(var1);
               if(!var27.equals(var3.text)) {
                  var3.text = var27;
                  Tile.method1577(var3);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 240) {
               class18.method204(false);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 21) {
               var1 = Client.field370.method3067();
               var2 = Client.field370.method3026();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var19 = Client.field370.method3037();
               var24 = class5.method79(var1);
               ItemComposition var22;
               if(!var24.field2068) {
                  if(var2 == -1) {
                     var24.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var22 = class18.getItemDefinition(var2);
                  var24.modelType = 4;
                  var24.modelId = var2;
                  var24.rotationX = var22.field2955;
                  var24.rotationZ = var22.field2982;
                  var24.field2134 = var22.field2952 * 100 / var19;
                  Tile.method1577(var24);
               } else {
                  var24.item = var2;
                  var24.stackSize = var19;
                  var22 = class18.getItemDefinition(var2);
                  var24.rotationX = var22.field2955;
                  var24.rotationZ = var22.field2982;
                  var24.rotationY = var22.field2977;
                  var24.field2131 = var22.field2940;
                  var24.field2119 = var22.field2959;
                  var24.field2134 = var22.field2952;
                  if(var22.isStackable == 1) {
                     var24.field2127 = 1;
                  } else {
                     var24.field2127 = 2;
                  }

                  if(var24.field2124 > 0) {
                     var24.field2134 = var24.field2134 * 32 / var24.field2124;
                  } else if(var24.field2144 > 0) {
                     var24.field2134 = var24.field2134 * 32 / var24.field2144;
                  }

                  Tile.method1577(var24);
               }

               Client.packetOpcode = -1;
               return true;
            }

            class39.method772("" + Client.packetOpcode + "," + Client.field338 + "," + Client.field339 + "," + Client.field564, (Throwable)null);
            GameEngine.method2223();
         } catch (IOException var34) {
            if(Client.field405 > 0) {
               GameEngine.method2223();
            } else {
               class186.setGameState(40);
               WidgetNode.field176 = FileOnDisk.field1183;
               FileOnDisk.field1183 = null;
            }
         } catch (Exception var35) {
            var17 = "" + Client.packetOpcode + "," + Client.field338 + "," + Client.field339 + "," + Client.field564 + "," + (class40.localPlayer.pathX[0] + class16.baseX) + "," + (class40.localPlayer.pathY[0] + Client.baseY) + ",";

            for(var2 = 0; var2 < Client.field564 && var2 < 50; ++var2) {
               var17 = var17 + Client.field370.payload[var2] + ",";
            }

            class39.method772(var17, var35);
            GameEngine.method2223();
         }

         return true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1239026540"
   )
   public static void method631() {
      class194.field2849.reset();
   }
}
