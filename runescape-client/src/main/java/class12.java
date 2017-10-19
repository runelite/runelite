import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class12 implements Comparator {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(La;La;I)I",
      garbageValue = "-658389350"
   )
   int method62(class14 var1, class14 var2) {
      return var1.field296 < var2.field296?-1:(var2.field296 == var1.field296?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method62((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1496084024"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3666[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "-968138128"
   )
   public static File method72(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class35.field512 = new File(class33.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      File var23;
      if(class35.field512.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class35.field512, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.read(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.getJagString();
               if(var10 == 1) {
                  var5 = var8.getJagString();
               }
            } else {
               var4 = var8.getCESU8();
               if(var10 == 1) {
                  var5 = var8.getCESU8();
               }
            }

            var7.close();
         } catch (IOException var21) {
            var21.printStackTrace();
         }

         if(var4 != null) {
            var23 = new File(var4);
            if(!var23.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var23 = new File(var4, "test.dat");
            if(!class43.method607(var23, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label142:
         for(int var15 = 0; var15 < class267.field3671.length; ++var15) {
            for(int var16 = 0; var16 < class277.cacheLocations.length; ++var16) {
               File var17 = new File(class277.cacheLocations[var16] + class267.field3671[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class43.method607(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label142;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class33.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var22;
      if(var5 != null) {
         var22 = new File(var5);
         var23 = new File(var4);

         try {
            File[] var24 = var22.listFiles();
            File[] var18 = var24;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var23, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var22 = new File(var4);
         var8 = null;

         try {
            FileOnDisk var25 = new FileOnDisk(class35.field512, "rw", 10000L);
            Buffer var26 = new Buffer(500);
            var26.putByte(3);
            var26.putByte(var8 != null?1:0);
            var26.putCESU8(var22.getPath());
            if(var8 != null) {
               var26.putCESU8("");
            }

            var25.write(var26.payload, 0, var26.offset);
            var25.close();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "-7"
   )
   static String method71(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Timer.sessionToken != null) {
         var3 = "/p=" + Timer.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + Client.field929 + var3 + "/";
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "2"
   )
   static int method69(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class81.intStack[--class278.intStackSize];
         var3 = ItemLayer.method2454(var4);
      } else {
         var3 = var2?class251.field3392:class164.field2314;
      }

      if(var0 == 1100) {
         class278.intStackSize -= 2;
         var3.scrollX = class81.intStack[class278.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class81.intStack[class278.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class45.method647(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class81.intStack[--class278.intStackSize];
         class45.method647(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2671 = class81.intStack[--class278.intStackSize] == 1;
         class45.method647(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class81.intStack[--class278.intStackSize];
         class45.method647(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2745 = class81.intStack[--class278.intStackSize];
         class45.method647(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class81.intStack[--class278.intStackSize];
         class45.method647(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class81.intStack[--class278.intStackSize];
         class45.method647(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2727 = class81.intStack[--class278.intStackSize] == 1;
         class45.method647(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class81.intStack[--class278.intStackSize];
         class45.method647(var3);
         return 1;
      } else if(var0 == 1109) {
         class278.intStackSize -= 6;
         var3.field2737 = class81.intStack[class278.intStackSize];
         var3.field2692 = class81.intStack[class278.intStackSize + 1];
         var3.rotationX = class81.intStack[class278.intStackSize + 2];
         var3.rotationZ = class81.intStack[class278.intStackSize + 3];
         var3.rotationY = class81.intStack[class278.intStackSize + 4];
         var3.modelZoom = class81.intStack[class278.intStackSize + 5];
         class45.method647(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class81.intStack[--class278.intStackSize];
            if(var9 != var3.field2711) {
               var3.field2711 = var9;
               var3.field2680 = 0;
               var3.field2765 = 0;
               class45.method647(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2699 = class81.intStack[--class278.intStackSize] == 1;
            class45.method647(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class81.scriptStringStack[--class266.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class45.method647(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class81.intStack[--class278.intStackSize];
            class45.method647(var3);
            return 1;
         } else if(var0 == 1114) {
            class278.intStackSize -= 3;
            var3.field2705 = class81.intStack[class278.intStackSize];
            var3.field2706 = class81.intStack[class278.intStackSize + 1];
            var3.field2704 = class81.intStack[class278.intStackSize + 2];
            class45.method647(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class81.intStack[--class278.intStackSize] == 1;
            class45.method647(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class81.intStack[--class278.intStackSize];
            class45.method647(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class81.intStack[--class278.intStackSize];
            class45.method647(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class81.intStack[--class278.intStackSize] == 1;
            class45.method647(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class81.intStack[--class278.intStackSize] == 1;
            class45.method647(var3);
            return 1;
         } else if(var0 == 1120) {
            class278.intStackSize -= 2;
            var3.scrollWidth = class81.intStack[class278.intStackSize];
            var3.scrollHeight = class81.intStack[class278.intStackSize + 1];
            class45.method647(var3);
            if(var4 != -1 && var3.type == 0) {
               GZipDecompressor.method3159(class215.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class51.method761(var3.id, var3.index);
            Client.field1078 = var3;
            class45.method647(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2678 = class81.intStack[--class278.intStackSize];
            class45.method647(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2668 = class81.intStack[--class278.intStackSize];
            class45.method647(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2674 = class81.intStack[--class278.intStackSize];
            class45.method647(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class81.intStack[--class278.intStackSize];
            class284[] var6 = new class284[]{class284.field3779, class284.field3780, class284.field3784, class284.field3782, class284.field3781};
            class284 var7 = (class284)class29.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2672 = var7;
               class45.method647(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class81.intStack[--class278.intStackSize] == 1;
            var3.field2676 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
