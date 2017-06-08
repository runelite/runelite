import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class10 extends class9 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1692662481
   )
   final int field255;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1488739541
   )
   final int field256;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1443886907
   )
   final int field257;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 959101287
   )
   final int field258;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1081305563
   )
   final int field259;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -506176163
   )
   final int field260;
   @ObfuscatedName("z")
   static byte[][][] field261;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -765051973
   )
   final int field262;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1699185912"
   )
   final void vmethod62() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field260:this.field257;
         int var2 = (var4 & 2) == 0?this.field259:this.field258;
         int var3 = (var4 & 4) == 0?this.field256:this.field262;
         if((var4 & 1) == 0) {
            class71.method1084(var1, var2, var3, this.field257, var2, var3, this.field255);
         }

         if((var4 & 2) == 0) {
            class71.method1084(var1, var2, var3, var1, this.field258, var3, this.field255);
         }

         if((var4 & 4) == 0) {
            class71.method1084(var1, var2, var3, var1, var2, this.field262, this.field255);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "-19114"
   )
   static int method63(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class177.method3390(class83.intStack[--class165.intStackSize]);
      } else {
         var3 = var2?class278.field3737:class37.field515;
      }

      CombatInfo1.method1515(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--class165.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class168.localPlayer.composition.method3980();
            return 1;
         } else {
            return 2;
         }
      } else {
         class165.intStackSize -= 2;
         int var4 = class83.intStack[class165.intStackSize];
         int var5 = class83.intStack[class165.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = ItemComposition.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2680 = var6.offsetX2d;
         var3.field2702 = var6.offsetY2d;
         var3.field2706 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2710 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2710 = 1;
         } else {
            var3.field2710 = 2;
         }

         if(var3.field2689 > 0) {
            var3.field2706 = var3.field2706 * 32 / var3.field2689;
         } else if(var3.originalWidth > 0) {
            var3.field2706 = var3.field2706 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-805297435"
   )
   static final void method65(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.method3395(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.method3400(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field953[++Client.field952 - 1] = var1;
               var3.field1261 = Client.gameCycle;
               int var4 = Client.secretPacketBuffer2.method3400(1);
               if(var4 == 1) {
                  Client.field955[++Client.field954 - 1] = var1;
               }

               var3.composition = class217.getNpcDefinition(Client.secretPacketBuffer2.method3400(14));
               int var5 = Client.secretPacketBuffer2.method3400(1);
               int var6;
               if(var0) {
                  var6 = Client.secretPacketBuffer2.method3400(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = Client.secretPacketBuffer2.method3400(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = Client.field1043[Client.secretPacketBuffer2.method3400(3)];
               if(var2) {
                  var3.field1252 = var3.angle = var7;
               }

               int var8;
               if(var0) {
                  var8 = Client.secretPacketBuffer2.method3400(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.secretPacketBuffer2.method3400(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field1230 = var3.composition.field3577;
               var3.field1242 = var3.composition.field3564;
               if(var3.field1242 == 0) {
                  var3.angle = 0;
               }

               var3.field1234 = var3.composition.field3579;
               var3.field1235 = var3.composition.field3571;
               var3.field1265 = var3.composition.field3572;
               var3.field1237 = var3.composition.field3573;
               var3.idlePoseAnimation = var3.composition.field3574;
               var3.field1232 = var3.composition.field3568;
               var3.field1248 = var3.composition.field3569;
               var3.method1667(var6 + class168.localPlayer.pathX[0], class168.localPlayer.pathY[0] + var8, var5 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.method3401();
         return;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "0"
   )
   static int method67(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--class165.intStackSize];
         var3 = class177.method3390(var4);
      } else {
         var3 = var2?class278.field3737:class37.field515;
      }

      if(var0 == 1100) {
         class165.intStackSize -= 2;
         var3.scrollX = class83.intStack[class165.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[class165.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--class165.intStackSize];
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2745 = class83.intStack[--class165.intStackSize] == 1;
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--class165.intStackSize];
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2685 = class83.intStack[--class165.intStackSize];
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--class165.intStackSize];
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2642 = class83.intStack[--class165.intStackSize];
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2690 = class83.intStack[--class165.intStackSize] == 1;
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--class165.intStackSize];
         CombatInfo1.method1515(var3);
         return 1;
      } else if(var0 == 1109) {
         class165.intStackSize -= 6;
         var3.field2680 = class83.intStack[class165.intStackSize];
         var3.field2702 = class83.intStack[class165.intStackSize + 1];
         var3.rotationX = class83.intStack[class165.intStackSize + 2];
         var3.rotationZ = class83.intStack[class165.intStackSize + 3];
         var3.rotationY = class83.intStack[class165.intStackSize + 4];
         var3.field2706 = class83.intStack[class165.intStackSize + 5];
         CombatInfo1.method1515(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class83.intStack[--class165.intStackSize];
            if(var3.field2699 != var8) {
               var3.field2699 = var8;
               var3.field2774 = 0;
               var3.field2662 = 0;
               CombatInfo1.method1515(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2709 = class83.intStack[--class165.intStackSize] == 1;
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               CombatInfo1.method1515(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--class165.intStackSize];
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1114) {
            class165.intStackSize -= 3;
            var3.field2715 = class83.intStack[class165.intStackSize];
            var3.field2714 = class83.intStack[class165.intStackSize + 1];
            var3.field2669 = class83.intStack[class165.intStackSize + 2];
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2717 = class83.intStack[--class165.intStackSize] == 1;
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--class165.intStackSize];
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--class165.intStackSize];
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--class165.intStackSize] == 1;
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--class165.intStackSize] == 1;
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1120) {
            class165.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[class165.intStackSize];
            var3.scrollHeight = class83.intStack[class165.intStackSize + 1];
            CombatInfo1.method1515(var3);
            if(var4 != -1 && var3.type == 0) {
               class21.method174(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class31.method286(var3.id, var3.index);
            Client.field1147 = var3;
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2688 = class83.intStack[--class165.intStackSize];
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2775 = class83.intStack[--class165.intStackSize];
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2684 = class83.intStack[--class165.intStackSize];
            CombatInfo1.method1515(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class83.intStack[--class165.intStackSize];
            class283 var6 = (class283)Projectile.method1737(class174.method3356(), var8);
            if(var6 != null) {
               var3.field2668 = var6;
               CombatInfo1.method1515(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--class165.intStackSize] == 1;
            var3.field2686 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1078688830"
   )
   public static byte method68(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 == 8364) {
            var1 = -128;
         } else if(var0 == 8218) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(var0 == 8230) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(var0 == 8225) {
            var1 = -121;
         } else if(var0 == 710) {
            var1 = -120;
         } else if(var0 == 8240) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(var0 == 338) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(var0 == 8216) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(var0 == 8220) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(var0 == 8226) {
            var1 = -107;
         } else if(var0 == 8211) {
            var1 = -106;
         } else if(var0 == 8212) {
            var1 = -105;
         } else if(var0 == 732) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(var0 == 353) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(var0 == 339) {
            var1 = -100;
         } else if(var0 == 382) {
            var1 = -98;
         } else if(var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "703349467"
   )
   static final String[] method69(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field260 = var2 + var1.field1992 - var1.field1966;
      this.field259 = var1.field1932 + var3 - var1.field1967;
      this.field256 = var4 + var1.field1933 - var1.field1953;
      this.field257 = var2 + var1.field1992 + var1.field1966;
      this.field258 = var1.field1967 + var1.field1932 + var3;
      this.field262 = var4 + var1.field1933 + var1.field1953;
      this.field255 = var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILIndexDataBase;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "0"
   )
   public static void method71(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method4141(var2);
      int var7 = var1.method4209(var6, var3);
      class54.method775(var0, var1, var6, var7, var4, var5);
   }
}
