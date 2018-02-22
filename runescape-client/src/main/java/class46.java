import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class46 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static Track1 field550;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -789497129
   )
   int field549;
   @ObfuscatedName("q")
   byte[][][] field546;

   class46(int var1) {
      this.field549 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1348047771"
   )
   void method684(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field549 != 0 && this.field546 != null) {
         var8 = this.method685(var8, var7);
         var7 = this.method689(var7);
         Rasterizer2D.method5680(var1, var2, var5, var6, var3, var4, this.field546[var7 - 1][var8], this.field549);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1660987072"
   )
   int method685(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "116243928"
   )
   int method689(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-122"
   )
   void method687() {
      if(this.field546 == null) {
         this.field546 = new byte[8][4][];
         this.method717();
         this.method693();
         this.method690();
         this.method683();
         this.method692();
         this.method705();
         this.method722();
         this.method695();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1225946623"
   )
   void method717() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[0][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[0][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[0][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[0][3] = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-113274709"
   )
   void method693() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[1][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field546[1][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[1][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[1][3] = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2367829"
   )
   void method690() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[2][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[2][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[2][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[2][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   void method683() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[3][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[3][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[3][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[3][3] = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "46"
   )
   void method692() {
      byte[] var1 = new byte[this.field549 * this.field549];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[4][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[4][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[4][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var2 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field546[4][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "549941243"
   )
   void method705() {
      byte[] var1 = new byte[this.field549 * this.field549];
      boolean var2 = false;
      var1 = new byte[this.field549 * this.field549];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[5][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var3 <= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[5][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[5][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var3 >= this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[5][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1402666519"
   )
   void method722() {
      byte[] var1 = new byte[this.field549 * this.field549];
      boolean var2 = false;
      var1 = new byte[this.field549 * this.field549];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[6][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[6][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[6][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[6][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "161001090"
   )
   void method695() {
      byte[] var1 = new byte[this.field549 * this.field549];
      boolean var2 = false;
      var1 = new byte[this.field549 * this.field549];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[7][0] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field549; ++var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[7][1] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = this.field549 - 1; var3 >= 0; --var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[7][2] = var1;
      var1 = new byte[this.field549 * this.field549];
      var5 = 0;

      for(var3 = 0; var3 < this.field549; ++var3) {
         for(var4 = this.field549 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field549 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field546[7][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "23463"
   )
   public static final boolean method712() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field582 == KeyFocusListener.field569) {
            return false;
         } else {
            Resampler.field1563 = KeyFocusListener.field577[KeyFocusListener.field569];
            class5.field29 = KeyFocusListener.field590[KeyFocusListener.field569];
            KeyFocusListener.field569 = KeyFocusListener.field569 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "-1526885596"
   )
   static int method691(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
         class149.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class80.intStackSize -= 2;
         PacketNode.method3441(OwnWorldComparator.localPlayer, class80.intStack[class80.intStackSize], class80.intStack[class80.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         MilliTimer.method3192();
         return 1;
      } else {
         int var5;
         int var15;
         if(var0 == 3104) {
            var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
            var15 = 0;
            if(FriendManager.method1748(var3)) {
               var5 = class162.parseInt(var3, 10, true);
               var15 = var5;
            }

            PacketNode var19 = class61.method1076(ClientPacket.field2342, Client.field863.field1434);
            var19.packetBuffer.putInt(var15);
            Client.field863.method2039(var19);
            return 1;
         } else {
            PacketNode var20;
            if(var0 == 3105) {
               var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
               var20 = class61.method1076(ClientPacket.field2434, Client.field863.field1434);
               var20.packetBuffer.putByte(var3.length() + 1);
               var20.packetBuffer.putString(var3);
               Client.field863.method2039(var20);
               return 1;
            } else if(var0 == 3106) {
               var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
               var20 = class61.method1076(ClientPacket.field2409, Client.field863.field1434);
               var20.packetBuffer.putByte(var3.length() + 1);
               var20.packetBuffer.putString(var3);
               Client.field863.method2039(var20);
               return 1;
            } else {
               String var13;
               int var14;
               if(var0 != 3107) {
                  if(var0 == 3108) {
                     class80.intStackSize -= 3;
                     var14 = class80.intStack[class80.intStackSize];
                     var15 = class80.intStack[class80.intStackSize + 1];
                     var5 = class80.intStack[class80.intStackSize + 2];
                     Widget var17 = NetWriter.getWidget(var5);
                     ScriptVarType.method26(var17, var14, var15);
                     return 1;
                  } else if(var0 == 3109) {
                     class80.intStackSize -= 2;
                     var14 = class80.intStack[class80.intStackSize];
                     var15 = class80.intStack[class80.intStackSize + 1];
                     Widget var18 = var2?class223.field2643:class80.field1228;
                     ScriptVarType.method26(var18, var14, var15);
                     return 1;
                  } else if(var0 == 3110) {
                     Size.middleMouseMovesCamera = class80.intStack[--class80.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3111) {
                     class80.intStack[++class80.intStackSize - 1] = Client.preferences.hideRoofs?1:0;
                     return 1;
                  } else if(var0 == 3112) {
                     Client.preferences.hideRoofs = class80.intStack[--class80.intStackSize] == 1;
                     VertexNormal.method2802();
                     return 1;
                  } else if(var0 == 3113) {
                     var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                     boolean var4 = class80.intStack[--class80.intStackSize] == 1;
                     class176.method3424(var3, var4, false);
                     return 1;
                  } else if(var0 == 3115) {
                     var14 = class80.intStack[--class80.intStackSize];
                     var20 = class61.method1076(ClientPacket.field2390, Client.field863.field1434);
                     var20.packetBuffer.putShort(var14);
                     Client.field863.method2039(var20);
                     return 1;
                  } else if(var0 == 3116) {
                     var14 = class80.intStack[--class80.intStackSize];
                     class43.scriptStringStackSize -= 2;
                     var13 = class80.scriptStringStack[class43.scriptStringStackSize];
                     String var12 = class80.scriptStringStack[class43.scriptStringStackSize + 1];
                     if(var13.length() > 500) {
                        return 1;
                     } else if(var12.length() > 500) {
                        return 1;
                     } else {
                        PacketNode var16 = class61.method1076(ClientPacket.field2345, Client.field863.field1434);
                        var16.packetBuffer.putShort(1 + class43.getLength(var13) + class43.getLength(var12));
                        var16.packetBuffer.method3574(var14);
                        var16.packetBuffer.putString(var13);
                        var16.packetBuffer.putString(var12);
                        Client.field863.method2039(var16);
                        return 1;
                     }
                  } else if(var0 == 3117) {
                     Client.field951 = class80.intStack[--class80.intStackSize] == 1;
                     return 1;
                  } else if(var0 == 3118) {
                     Client.field925 = class80.intStack[--class80.intStackSize] == 1;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var14 = class80.intStack[--class80.intStackSize];
                  var13 = class80.scriptStringStack[--class43.scriptStringStackSize];
                  var5 = class92.playerIndexesCount;
                  int[] var6 = class92.playerIndices;
                  boolean var7 = false;
                  Name var8 = new Name(var13, class234.loginType);

                  for(int var9 = 0; var9 < var5; ++var9) {
                     Player var10 = Client.cachedPlayers[var6[var9]];
                     if(var10 != null && var10 != OwnWorldComparator.localPlayer && var10.name != null && var10.name.equals(var8)) {
                        PacketNode var11;
                        if(var14 == 1) {
                           var11 = class61.method1076(ClientPacket.field2408, Client.field863.field1434);
                           var11.packetBuffer.method3574(0);
                           var11.packetBuffer.putShort(var6[var9]);
                           Client.field863.method2039(var11);
                        } else if(var14 == 4) {
                           var11 = class61.method1076(ClientPacket.field2388, Client.field863.field1434);
                           var11.packetBuffer.method3574(0);
                           var11.packetBuffer.writeShortLE(var6[var9]);
                           Client.field863.method2039(var11);
                        } else if(var14 == 6) {
                           var11 = class61.method1076(ClientPacket.field2338, Client.field863.field1434);
                           var11.packetBuffer.putShortLE(0);
                           var11.packetBuffer.putShort(var6[var9]);
                           Client.field863.method2039(var11);
                        } else if(var14 == 7) {
                           var11 = class61.method1076(ClientPacket.field2389, Client.field863.field1434);
                           var11.packetBuffer.writeIntLE16(var6[var9]);
                           var11.packetBuffer.method3573(0);
                           Client.field863.method2039(var11);
                        }

                        var7 = true;
                        break;
                     }
                  }

                  if(!var7) {
                     class149.sendGameMessage(4, "", "Unable to find " + var13);
                  }

                  return 1;
               }
            }
         }
      }
   }
}
