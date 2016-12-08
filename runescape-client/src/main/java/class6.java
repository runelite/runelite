import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class6 implements Comparator {
   @ObfuscatedName("cx")
   static class110 field46;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1416967111"
   )
   int method65(class2 var1, class2 var2) {
      return var1.method24().compareTo(var2.method24());
   }

   public int compare(Object var1, Object var2) {
      return this.method65((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "1743398848"
   )
   static final void method72(class159 var0) {
      for(int var1 = 0; var1 < class45.field904; ++var1) {
         int var2 = class45.field909[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 16) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 2) != 0) {
            var6 = var0.readUnsignedByte();
            byte[] var17 = new byte[var6];
            Buffer var18 = new Buffer(var17);
            var0.method2796(var17, 0, var6);
            class45.field917[var2] = var18;
            var3.method210(var18);
         }

         int var7;
         if((var4 & 1) != 0) {
            var6 = var0.readUnsignedShort();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var7 = var0.readUnsignedByte();
            class30.method645(var3, var6, var7);
         }

         if((var4 & 8) != 0) {
            var3.interacting = var0.readUnsignedShort();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 32) != 0) {
            var3.overhead = var0.method2780();
            if(var3.overhead.charAt(0) == 126) {
               var3.overhead = var3.overhead.substring(1);
               class16.method183(2, var3.name, var3.overhead);
            } else if(var3 == class5.localPlayer) {
               class16.method183(2, var3.name, var3.overhead);
            }

            var3.field617 = false;
            var3.field608 = 0;
            var3.field621 = 0;
            var3.field619 = 150;
         }

         int var10;
         int var11;
         if((var4 & 128) != 0) {
            var6 = var0.readUnsignedByte();
            int var8;
            int var9;
            int var12;
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var8 = var0.method2842();
                  if(var8 == 32767) {
                     var8 = var0.method2842();
                     var10 = var0.method2842();
                     var9 = var0.method2842();
                     var11 = var0.method2842();
                  } else if(var8 != 32766) {
                     var10 = var0.method2842();
                  } else {
                     var8 = -1;
                  }

                  var12 = var0.method2842();
                  var3.method577(var8, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var7 = var0.readUnsignedByte();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var0.method2842();
                  var10 = var0.method2842();
                  if(var10 != 32767) {
                     var11 = var0.method2842();
                     var12 = var0.readUnsignedByte();
                     int var13 = var10 > 0?var0.readUnsignedByte():var12;
                     var3.method574(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var3.method571(var9);
                  }
               }
            }
         }

         if((var4 & 64) != 0) {
            var3.field614 = var0.readUnsignedShort();
            if(var3.field656 == 0) {
               var3.field655 = var3.field614;
               var3.field614 = -1;
            }
         }

         if((var4 & 4) != 0) {
            var6 = var0.readUnsignedShort();
            class177[] var23 = new class177[]{class177.field2672, class177.field2673, class177.field2669, class177.field2671, class177.field2676, class177.field2668};
            class177 var24 = (class177)FileOnDisk.method1390(var23, var0.readUnsignedByte());
            boolean var21 = var0.readUnsignedByte() == 1;
            var10 = var0.readUnsignedByte();
            var11 = var0.offset;
            if(null != var3.name && var3.composition != null) {
               boolean var22 = false;
               if(var24.field2677 && XItemContainer.method150(var3.name)) {
                  var22 = true;
               }

               if(!var22 && Client.field542 == 0 && !var3.field268) {
                  class45.field910.offset = 0;
                  var0.method2796(class45.field910.payload, 0, var10);
                  class45.field910.offset = 0;
                  Buffer var14 = class45.field910;
                  String var19 = class114.method2157(var14, 32767);
                  String var15 = class209.method3783(Widget.method3158(var19));
                  var3.overhead = var15.trim();
                  var3.field608 = var6 >> 8;
                  var3.field621 = var6 & 255;
                  var3.field619 = 150;
                  var3.field617 = var21;
                  var3.inSequence = class5.localPlayer != var3 && var24.field2677 && "" != Client.field303 && var15.toLowerCase().indexOf(Client.field303) == -1;
                  int var16;
                  if(var24.field2680) {
                     var16 = var21?91:1;
                  } else {
                     var16 = var21?90:2;
                  }

                  if(var24.field2675 != -1) {
                     class16.method183(var16, class13.method166(var24.field2675) + var3.name, var15);
                  } else {
                     class16.method183(var16, var3.name, var15);
                  }
               }
            }

            var0.offset = var10 + var11;
         }

         if((var4 & 1024) != 0) {
            var3.graphic = var0.readUnsignedShort();
            var6 = var0.method2731();
            var3.field654 = var6 >> 16;
            var3.field644 = (var6 & '\uffff') + Client.gameCycle;
            var3.field642 = 0;
            var3.field664 = 0;
            if(var3.field644 > Client.gameCycle) {
               var3.field642 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 2048) != 0) {
            var3.field658 = var0.readByte();
            var3.field632 = var0.readByte();
            var3.field647 = var0.readByte();
            var3.field649 = var0.readByte();
            var3.field650 = var0.readUnsignedShort() + Client.gameCycle;
            var3.field651 = var0.readUnsignedShort() + Client.gameCycle;
            var3.field652 = var0.readUnsignedShort();
            if(var3.field271) {
               var3.field658 += var3.field272;
               var3.field632 += var3.field251;
               var3.field647 += var3.field272;
               var3.field649 += var3.field251;
               var3.field656 = 0;
            } else {
               var3.field658 += var3.pathX[0];
               var3.field632 += var3.pathY[0];
               var3.field647 += var3.pathX[0];
               var3.field649 += var3.pathY[0];
               var3.field656 = 1;
            }

            var3.field663 = 0;
         }

         if((var4 & 256) != 0) {
            class45.field916[var2] = var0.readByte();
         }

         if((var4 & 512) != 0) {
            var5 = var0.readByte();
         }

         if((var4 & 4096) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.method2780();
            }
         }

         if(var3.field271) {
            if(var5 == 127) {
               var3.method213(var3.field272, var3.field251);
            } else {
               byte var20;
               if(var5 != -1) {
                  var20 = var5;
               } else {
                  var20 = class45.field916[var2];
               }

               var3.method212(var3.field272, var3.field251, var20);
            }
         }
      }

   }
}
