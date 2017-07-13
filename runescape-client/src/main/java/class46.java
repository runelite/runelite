import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class46 {
   @ObfuscatedName("mg")
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("n")
   @Export("skin_ref")
   static IndexDataBase skin_ref;
   @ObfuscatedName("j")
   byte[][][] field583;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1647724343
   )
   int field587;

   class46(int var1) {
      this.field587 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1228962739"
   )
   void method697() {
      byte[] var1 = new byte[this.field587 * this.field587];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[0][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[0][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[0][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[0][3] = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-2"
   )
   int method671(int var1, int var2) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-73"
   )
   void method676() {
      byte[] var1 = new byte[this.field587 * this.field587];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[1][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
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

      this.field583[1][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[1][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[1][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "39933279"
   )
   int method672(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "40"
   )
   void method677() {
      byte[] var1 = new byte[this.field587 * this.field587];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[2][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[2][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[2][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[2][3] = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-568364635"
   )
   void method690() {
      byte[] var1 = new byte[this.field587 * this.field587];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[3][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[3][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[3][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[3][3] = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "27363"
   )
   void method679() {
      byte[] var1 = new byte[this.field587 * this.field587];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[4][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[4][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[4][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var2 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field583[4][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   void method680() {
      byte[] var1 = new byte[this.field587 * this.field587];
      boolean var2 = false;
      var1 = new byte[this.field587 * this.field587];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[5][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var3 <= this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[5][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[5][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var3 >= this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[5][3] = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "865412205"
   )
   void method681() {
      byte[] var1 = new byte[this.field587 * this.field587];
      boolean var2 = false;
      var1 = new byte[this.field587 * this.field587];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[6][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 <= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[6][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[6][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[6][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "6"
   )
   void method670(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field587 != 0 && this.field583 != null) {
         var8 = this.method671(var8, var7);
         var7 = this.method672(var7);
         Rasterizer2D.method4860(var1, var2, var5, var6, var3, var4, this.field583[var7 - 1][var8], this.field587);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-56248018"
   )
   void method682() {
      byte[] var1 = new byte[this.field587 * this.field587];
      boolean var2 = false;
      var1 = new byte[this.field587 * this.field587];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[7][0] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field587; ++var4) {
            if(var4 >= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[7][1] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = this.field587 - 1; var3 >= 0; --var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[7][2] = var1;
      var1 = new byte[this.field587 * this.field587];
      var5 = 0;

      for(var3 = 0; var3 < this.field587; ++var3) {
         for(var4 = this.field587 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field587 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field583[7][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "954017523"
   )
   void method678() {
      if(this.field583 == null) {
         this.field583 = new byte[8][4][];
         this.method697();
         this.method676();
         this.method677();
         this.method690();
         this.method679();
         this.method680();
         this.method681();
         this.method682();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "0"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2408) {
         class175.field2411 += class175.field2408 - var0;
      }

      class175.field2408 = var0;
      return class175.field2411 + var0;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1928899519"
   )
   static final void method712() {
      if(KeyFocusListener.soundSystem1 != null) {
         KeyFocusListener.soundSystem1.method1985();
      }

      if(class290.soundSystem0 != null) {
         class290.soundSystem0.method1985();
      }

   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(LWidget;B)I",
      garbageValue = "19"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      WidgetConfig var1 = (WidgetConfig)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.config:var0.config;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-231404078"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "993242949"
   )
   static final void method708() {
      Client.secretPacketBuffer2.bitAccess();
      int var0 = Client.secretPacketBuffer2.getBits(8);
      int var1;
      if(var0 < Client.field944) {
         for(var1 = var0; var1 < Client.field944; ++var1) {
            Client.field1030[++Client.field1029 - 1] = Client.npcIndices[var1];
         }
      }

      if(var0 > Client.field944) {
         throw new RuntimeException("");
      } else {
         Client.field944 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.npcIndices[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.getBits(1);
            if(var4 == 0) {
               Client.npcIndices[++Client.field944 - 1] = var2;
               var3.field1263 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.getBits(2);
               if(var5 == 0) {
                  Client.npcIndices[++Client.field944 - 1] = var2;
                  var3.field1263 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.npcIndices[++Client.field944 - 1] = var2;
                     var3.field1263 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1663(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.getBits(1);
                     if(var7 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.npcIndices[++Client.field944 - 1] = var2;
                     var3.field1263 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1663(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1663(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1030[++Client.field1029 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-106"
   )
   public static final boolean method713(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
