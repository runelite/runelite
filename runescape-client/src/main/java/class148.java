import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class148 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 499149245
   )
   public static int field2033;

   static {
      new HashMap();
   }

   class148() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass159;ILPlayer;II)V",
      garbageValue = "1808648014"
   )
   static final void method2792(CipherBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 128) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytes(var6, 0, var5);
         class45.field923[var1] = var7;
         var2.method244(var7);
      }

      int var14;
      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedShort();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var14 = var0.readUnsignedByte();
         class94.method1979(var2, var5, var14);
      }

      if((var3 & 16) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 2) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class30.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == class22.localPlayer) {
            class30.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field639 = false;
         var2.field642 = 0;
         var2.field643 = 0;
         var2.field641 = 150;
      }

      int var9;
      int var10;
      if((var3 & 32) != 0) {
         var5 = var0.readUnsignedByte();
         int var8;
         int var11;
         int var15;
         if(var5 > 0) {
            for(var14 = 0; var14 < var5; ++var14) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var15 = var0.method3013();
               if(var15 == 32767) {
                  var15 = var0.method3013();
                  var9 = var0.method3013();
                  var8 = var0.method3013();
                  var10 = var0.method3013();
               } else if(var15 != 32766) {
                  var9 = var0.method3013();
               } else {
                  var15 = -1;
               }

               var11 = var0.method3013();
               var2.method609(var15, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var14 = var0.readUnsignedByte();
         if(var14 > 0) {
            for(var15 = 0; var15 < var14; ++var15) {
               var8 = var0.method3013();
               var9 = var0.method3013();
               if(var9 != 32767) {
                  var10 = var0.method3013();
                  var11 = var0.readUnsignedByte();
                  int var16 = var9 > 0?var0.readUnsignedByte():var11;
                  var2.method607(var8, Client.gameCycle, var9, var10, var11, var16);
               } else {
                  var2.method606(var8);
               }
            }
         }
      }

      if((var3 & 1) != 0) {
         var2.field653 = var0.readUnsignedShort();
         if(var2.field679 == 0) {
            var2.field676 = var2.field653;
            var2.field653 = -1;
         }
      }

      if((var3 & 4) != 0) {
         var5 = var0.readUnsignedShort();
         class177[] var17 = new class177[]{class177.field2655, class177.field2659, class177.field2653, class177.field2652, class177.field2657, class177.field2654};
         class177 var18 = (class177)class5.method77(var17, var0.readUnsignedByte());
         boolean var20 = var0.readUnsignedByte() == 1;
         var9 = var0.readUnsignedByte();
         var10 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var21 = false;
            if(var18.field2660 && GameEngine.method2242(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.field432 == 0 && !var2.field290) {
               class45.field933.offset = 0;
               var0.readBytes(class45.field933.payload, 0, var9);
               class45.field933.offset = 0;
               String var12 = FontTypeFace.method3880(XGrandExchangeOffer.method64(class174.method3270(class45.field933)));
               var2.overhead = var12.trim();
               var2.field642 = var5 >> 8;
               var2.field643 = var5 & 255;
               var2.field641 = 150;
               var2.field639 = var20;
               var2.inSequence = class22.localPlayer != var2 && var18.field2660 && Client.field533 != "" && var12.toLowerCase().indexOf(Client.field533) == -1;
               int var13;
               if(var18.field2661) {
                  var13 = var20?91:1;
               } else {
                  var13 = var20?90:2;
               }

               if(var18.field2658 != -1) {
                  class30.sendGameMessage(var13, class112.method2140(var18.field2658) + var2.name, var12);
               } else {
                  class30.sendGameMessage(var13, var2.name, var12);
               }
            }
         }

         var0.offset = var10 + var9;
      }

      if((var3 & 512) != 0) {
         var2.graphic = var0.readUnsignedShort();
         var5 = var0.readInt();
         var2.field666 = var5 >> 16;
         var2.field665 = Client.gameCycle + (var5 & '\uffff');
         var2.field662 = 0;
         var2.field664 = 0;
         if(var2.field665 > Client.gameCycle) {
            var2.field662 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.field650 = var0.readByte();
         var2.field669 = var0.readByte();
         var2.field663 = var0.readByte();
         var2.field670 = var0.readByte();
         var2.field671 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field647 = var0.readUnsignedShort() + Client.gameCycle;
         var2.field673 = var0.readUnsignedShort();
         if(var2.field293) {
            var2.field650 += var2.field295;
            var2.field669 += var2.field284;
            var2.field663 += var2.field295;
            var2.field670 += var2.field284;
            var2.field679 = 0;
         } else {
            var2.field650 += var2.pathX[0];
            var2.field669 += var2.pathY[0];
            var2.field663 += var2.pathX[0];
            var2.field670 += var2.pathY[0];
            var2.field679 = 1;
         }

         var2.field636 = 0;
      }

      if((var3 & 4096) != 0) {
         class45.field935[var1] = var0.readByte();
      }

      if((var3 & 256) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 2048) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if(var2.field293) {
         if(var4 == 127) {
            var2.method248(var2.field295, var2.field284);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class45.field935[var1];
            }

            var2.method247(var2.field295, var2.field284, var19);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "-2127729551"
   )
   static void method2793(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2719;
      synchronized(class183.field2719) {
         for(class180 var5 = (class180)class183.field2719.method2448(); null != var5; var5 = (class180)class183.field2719.method2445()) {
            if(var5.hash == (long)var0 && var1 == var5.field2683 && var5.field2690 == 0) {
               var3 = var5.field2681;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3405(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2282(var0);
         var2.method3405(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIB)I",
      garbageValue = "-70"
   )
   static final int method2794(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1462[1024 * var2 / var3] >> 1;
      return (var1 * var4 >> 16) + ((65536 - var4) * var0 >> 16);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "1562015934"
   )
   static String method2795(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class39.method817(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(null != class105.field1733) {
               var7 = ISAACCipher.method3111(class105.field1733.field1671);
               if(null != class105.field1733.field1677) {
                  var7 = (String)class105.field1733.field1677;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
