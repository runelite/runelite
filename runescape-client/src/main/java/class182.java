import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public abstract class class182 {
   @ObfuscatedName("c")
   class122[] field2693;
   @ObfuscatedName("q")
   int[] field2694;
   @ObfuscatedName("o")
   int[] field2695;
   @ObfuscatedName("h")
   boolean field2696;
   @ObfuscatedName("r")
   class122 field2697;
   @ObfuscatedName("j")
   int[] field2698;
   @ObfuscatedName("w")
   int[] field2699;
   @ObfuscatedName("d")
   int[][] field2700;
   @ObfuscatedName("n")
   int[][] field2701;
   @ObfuscatedName("y")
   int[] field2702;
   @ObfuscatedName("s")
   Object[] field2703;
   @ObfuscatedName("g")
   Object[][] field2704;
   @ObfuscatedName("i")
   static class153 field2705 = new class153();
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2072438817
   )
   public int field2706;
   @ObfuscatedName("a")
   boolean field2707;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1043275333
   )
   static int field2709 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1108428937
   )
   int field2711;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1470895713"
   )
   public int method3270() {
      return this.field2704.length;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1139384829"
   )
   void method3271(byte[] var1) {
      this.field2706 = Friend.method191(var1, var1.length);
      Buffer var2 = new Buffer(class103.method1967(var1));
      int var3 = var2.readUnsignedByte();
      if(var3 >= 5 && var3 <= 7) {
         if(var3 >= 6) {
            var2.method3062();
         }

         int var4 = var2.readUnsignedByte();
         if(var3 >= 7) {
            this.field2711 = var2.method2940();
         } else {
            this.field2711 = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.field2702 = new int[this.field2711];
         int var7;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2711; ++var7) {
               this.field2702[var7] = var5 += var2.method2940();
               if(this.field2702[var7] > var6) {
                  var6 = this.field2702[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.field2711; ++var7) {
               this.field2702[var7] = var5 += var2.readUnsignedShort();
               if(this.field2702[var7] > var6) {
                  var6 = this.field2702[var7];
               }
            }
         }

         this.field2699 = new int[1 + var6];
         this.field2698 = new int[var6 + 1];
         this.field2694 = new int[1 + var6];
         this.field2700 = new int[1 + var6][];
         this.field2703 = new Object[var6 + 1];
         this.field2704 = new Object[var6 + 1][];
         if(var4 != 0) {
            this.field2695 = new int[var6 + 1];

            for(var7 = 0; var7 < this.field2711; ++var7) {
               this.field2695[this.field2702[var7]] = var2.method3062();
            }

            this.field2697 = new class122(this.field2695);
         }

         for(var7 = 0; var7 < this.field2711; ++var7) {
            this.field2699[this.field2702[var7]] = var2.method3062();
         }

         for(var7 = 0; var7 < this.field2711; ++var7) {
            this.field2698[this.field2702[var7]] = var2.method3062();
         }

         for(var7 = 0; var7 < this.field2711; ++var7) {
            this.field2694[this.field2702[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if(var3 >= 7) {
            for(var7 = 0; var7 < this.field2711; ++var7) {
               var8 = this.field2702[var7];
               var9 = this.field2694[var8];
               var5 = 0;
               var10 = -1;
               this.field2700[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2700[var8][var11] = var5 += var2.method2940();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2704[var8] = new Object[1 + var10];
            }
         } else {
            for(var7 = 0; var7 < this.field2711; ++var7) {
               var8 = this.field2702[var7];
               var9 = this.field2694[var8];
               var5 = 0;
               var10 = -1;
               this.field2700[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.field2700[var8][var11] = var5 += var2.readUnsignedShort();
                  if(var12 > var10) {
                     var10 = var12;
                  }
               }

               this.field2704[var8] = new Object[var10 + 1];
            }
         }

         if(var4 != 0) {
            this.field2701 = new int[1 + var6][];
            this.field2693 = new class122[1 + var6];

            for(var7 = 0; var7 < this.field2711; ++var7) {
               var8 = this.field2702[var7];
               var9 = this.field2694[var8];
               this.field2701[var8] = new int[this.field2704[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.field2701[var8][this.field2700[var8][var10]] = var2.method3062();
               }

               this.field2693[var8] = new class122(this.field2701[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1719871487"
   )
   void vmethod3365(int var1) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)[B",
      garbageValue = "-69"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2) {
      return this.getConfigData(var1, var2, (int[])null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1000834731"
   )
   @Export("getConfigData")
   public byte[] getConfigData(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2704.length && this.field2704[var1] != null && var2 >= 0 && var2 < this.field2704[var1].length) {
         if(this.field2704[var1][var2] == null) {
            boolean var5 = this.method3287(var1, var3);
            if(!var5) {
               this.vmethod3366(var1);
               var5 = this.method3287(var1, var3);
               if(!var5) {
                  return null;
               }
            }
         }

         byte[] var4 = World.method682(this.field2704[var1][var2], false);
         if(this.field2696) {
            this.field2704[var1][var2] = null;
         }

         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "65698813"
   )
   public boolean method3275(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2704.length && null != this.field2704[var1] && var2 >= 0 && var2 < this.field2704[var1].length) {
         if(null != this.field2704[var1][var2]) {
            return true;
         } else if(this.field2703[var1] != null) {
            return true;
         } else {
            this.vmethod3366(var1);
            return this.field2703[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2004349660"
   )
   public boolean method3276(int var1) {
      if(this.field2703[var1] != null) {
         return true;
      } else {
         this.vmethod3366(var1);
         return this.field2703[var1] != null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-43"
   )
   public boolean method3277() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2702.length; ++var2) {
         int var3 = this.field2702[var2];
         if(this.field2703[var3] == null) {
            this.vmethod3366(var3);
            if(null == this.field2703[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1943569321"
   )
   public byte[] method3278(int var1) {
      if(this.field2704.length == 1) {
         return this.getConfigData(0, var1);
      } else if(this.field2704[var1].length == 1) {
         return this.getConfigData(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "951635019"
   )
   public byte[] method3279(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2704.length && this.field2704[var1] != null && var2 >= 0 && var2 < this.field2704[var1].length) {
         if(this.field2704[var1][var2] == null) {
            boolean var3 = this.method3287(var1, (int[])null);
            if(!var3) {
               this.vmethod3366(var1);
               var3 = this.method3287(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = World.method682(this.field2704[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "662409620"
   )
   public byte[] method3280(int var1) {
      if(this.field2704.length == 1) {
         return this.method3279(0, var1);
      } else if(this.field2704[var1].length == 1) {
         return this.method3279(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-832673040"
   )
   void vmethod3366(int var1) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1359139795"
   )
   public int[] method3282(int var1) {
      return this.field2700[var1];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "609350944"
   )
   public int method3283(int var1) {
      return this.field2704[var1].length;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-2080486259"
   )
   public int method3284(String var1) {
      var1 = var1.toLowerCase();
      return this.field2697.method2308(class8.method113(var1));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)I",
      garbageValue = "802124040"
   )
   public int method3285(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2693[var1].method2308(class8.method113(var2));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1851882406"
   )
   public void method3286(int var1) {
      for(int var2 = 0; var2 < this.field2704[var1].length; ++var2) {
         this.field2704[var1][var2] = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[IB)Z",
      garbageValue = "4"
   )
   boolean method3287(int var1, int[] var2) {
      if(this.field2703[var1] == null) {
         return false;
      } else {
         int var3 = this.field2694[var1];
         int[] var4 = this.field2700[var1];
         Object[] var5 = this.field2704[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = World.method682(this.field2703[var1], false);
            } else {
               var18 = World.method682(this.field2703[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method3124(var2, 5, var8.payload.length);
            }

            byte[] var20 = class103.method1967(var18);
            if(this.field2707) {
               this.field2703[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method3062();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method3062();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2696) {
                     var5[var4[var15]] = class10.method125(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2696) {
               var5[var4[0]] = class10.method125(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-852980583"
   )
   public void method3288() {
      for(int var1 = 0; var1 < this.field2704.length; ++var1) {
         if(this.field2704[var1] != null) {
            for(int var2 = 0; var2 < this.field2704[var1].length; ++var2) {
               this.field2704[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "0"
   )
   public boolean method3291(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2697.method2308(class8.method113(var1));
      int var4 = this.field2693[var3].method2308(class8.method113(var2));
      return this.method3275(var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-897481304"
   )
   public boolean method3292(String var1) {
      int var2 = this.method3284("");
      return var2 != -1?this.method3291("", var1):this.method3291(var1, "");
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1799975289"
   )
   public void method3295(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2697.method2308(class8.method113(var1));
      if(var2 >= 0) {
         this.vmethod3365(var2);
      }
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "80"
   )
   static final void method3296(int var0) {
      Actor.method642();
      class22.method232();
      int var1 = class109.method2046(var0).field2757;
      if(var1 != 0) {
         int var2 = class146.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class84.method1648(0.9D);
               ((TextureProvider)class84.field1448).method1440(0.9D);
            }

            if(var2 == 2) {
               class84.method1648(0.8D);
               ((TextureProvider)class84.field1448).method1440(0.8D);
            }

            if(var2 == 3) {
               class84.method1648(0.7D);
               ((TextureProvider)class84.field1448).method1440(0.7D);
            }

            if(var2 == 4) {
               class84.method1648(0.6D);
               ((TextureProvider)class84.field1448).method1440(0.6D);
            }

            class9.method120();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field515) {
               if(Client.field515 == 0 && Client.field516 != -1) {
                  class159.method2909(ChatMessages.field923, Client.field516, 0, var3, false);
                  Client.field517 = false;
               } else if(var3 == 0) {
                  class85.method1702();
                  Client.field517 = false;
               } else if(class138.field1910 != 0) {
                  class97.field1631 = var3;
               } else {
                  class138.field1906.method2468(var3);
               }

               Client.field515 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field518 = 127;
            }

            if(var2 == 1) {
               Client.field518 = 96;
            }

            if(var2 == 2) {
               Client.field518 = 64;
            }

            if(var2 == 3) {
               Client.field518 = 32;
            }

            if(var2 == 4) {
               Client.field518 = 0;
            }
         }

         if(var1 == 5) {
            Client.field543 = var2;
         }

         if(var1 == 6) {
            Client.field439 = var2;
         }

         if(var1 == 9) {
            Client.field440 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field512 = 127;
            }

            if(var2 == 1) {
               Client.field512 = 96;
            }

            if(var2 == 2) {
               Client.field512 = 64;
            }

            if(var2 == 3) {
               Client.field512 = 32;
            }

            if(var2 == 4) {
               Client.field512 = 0;
            }
         }

         if(var1 == 17) {
            Client.field445 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field304 = (class40)CombatInfoListHolder.method732(class3.method47(), var2);
            if(null == Client.field304) {
               Client.field304 = class40.field818;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field407 = -1;
            } else {
               Client.field407 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field305 = (class40)CombatInfoListHolder.method732(class3.method47(), var2);
            if(Client.field305 == null) {
               Client.field305 = class40.field818;
            }
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LSpritePixels;",
      garbageValue = "-1088690723"
   )
   static SpritePixels[] method3333(class182 var0, int var1, int var2) {
      return !class63.method1175(var0, var1, var2)?null:BufferProvider.method4055();
   }

   class182(boolean var1, boolean var2) {
      this.field2707 = var1;
      this.field2696 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-746463963"
   )
   public byte[] method3341(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2697.method2308(class8.method113(var1));
      int var4 = this.field2693[var3].method2308(class8.method113(var2));
      return this.getConfigData(var3, var4);
   }
}
