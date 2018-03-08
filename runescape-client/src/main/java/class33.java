import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public final class class33 {
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1722286735
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("q")
   final int[] field436;

   class33() {
      this.field436 = new int[4096];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Law;I)V",
      garbageValue = "1825711728"
   )
   final void method369(class44 var1) {
      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field436[var2 * 64 + var3] = var1.method673(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-551338214"
   )
   final int method368(int var1, int var2) {
      return this.field436[var2 + var1 * 64];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Llu;I)Ljava/lang/String;",
      garbageValue = "2045053569"
   )
   public static String method374(CharSequence var0, JagexLoginType var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field4076) {
               case 5:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var12 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(VerticalAlignment.method4747(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class315.field3916;
                     int var10 = 0;

                     label120:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class315.field3919;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var11 == var7) {
                                 var8 = true;
                                 break label120;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var13[var10];
                        if(var7 == var11) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var9;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var9 = '_';
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var9 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var9 = 'a';
                        break;
                     case 'Ç':
                     case 'ç':
                        var9 = 'c';
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var9 = 'e';
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var9 = 'i';
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var9 = 'n';
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var9 = 'o';
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var9 = 'u';
                        break;
                     case 'ß':
                        var9 = 'b';
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var9 = 'y';
                        break;
                     default:
                        var9 = Character.toLowerCase(var7);
                     }

                     if(var9 != 0) {
                        var12.append(var9);
                     }
                  }
               }

               if(var12.length() == 0) {
                  return null;
               }

               return var12.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lfo;Lgv;I)Lgd;",
      garbageValue = "2122160393"
   )
   public static PacketNode method382(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2473 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2473];
      }

      var2.clientPacket = var0;
      var2.field2469 = var0.packetLength;
      if(var2.field2469 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2469 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2469 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2469 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2470 = 0;
      return var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;I)V",
      garbageValue = "-1859152199"
   )
   public static void method379(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      VarPlayerType.field3448 = VarPlayerType.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1664009867"
   )
   public static void method378(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "668920869"
   )
   static final void method381(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1097 - Client.field1052) * var5 / 100 + Client.field1052;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1102) {
         var15 = Client.field1102;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1101) {
            var6 = Client.field1101;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1103) {
         var15 = Client.field1103;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1100) {
            var6 = Client.field1100;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1099 - Client.field922) * var5 / 100 + Client.field922;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-183910464"
   )
   static void method380(boolean var0) {
      Client.field877 = var0;
   }
}
