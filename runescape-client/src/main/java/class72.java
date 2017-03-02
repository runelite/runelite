import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class72 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -6244434031224855865L
   )
   long field1159;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2937655130752377073L
   )
   long field1161 = -1L;
   @ObfuscatedName("b")
   FileOnDisk field1162;
   @ObfuscatedName("k")
   byte[] field1163;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6925004926954750567L
   )
   long field1164 = -1L;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1651148039
   )
   int field1165 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1764151445
   )
   int field1166;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -829172103035875505L
   )
   long field1167;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 1741010717977716895L
   )
   long field1169;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -724345871773552329L
   )
   long field1170;
   @ObfuscatedName("et")
   static SpritePixels[] field1171;
   @ObfuscatedName("l")
   byte[] field1172;
   @ObfuscatedName("c")
   static int[] field1173;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "13035037"
   )
   public void method1435() throws IOException {
      this.method1442();
      this.field1162.method1471();
   }

   @ObfuscatedName("l")
   public void method1436(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1170 = var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1535923595"
   )
   public void method1438(byte[] var1) throws IOException {
      this.method1439(var1, 0, var1.length);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1307853698"
   )
   public void method1439(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field1164 && this.field1170 >= this.field1164 && this.field1170 + (long)var3 <= this.field1164 + (long)this.field1165) {
            System.arraycopy(this.field1163, (int)(this.field1170 - this.field1164), var1, var2, var3);
            this.field1170 += (long)var3;
            return;
         }

         long var4 = this.field1170;
         int var7 = var3;
         int var8;
         if(this.field1170 >= this.field1161 && this.field1170 < this.field1161 + (long)this.field1166) {
            var8 = (int)((long)this.field1166 - (this.field1170 - this.field1161));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1172, (int)(this.field1170 - this.field1161), var1, var2, var8);
            this.field1170 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1172.length) {
            this.field1162.method1467(this.field1170);

            for(this.field1169 = this.field1170; var3 > 0; var3 -= var8) {
               var8 = this.field1162.method1469(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1169 += (long)var8;
               this.field1170 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1440();
            var8 = var3;
            if(var3 > this.field1166) {
               var8 = this.field1166;
            }

            System.arraycopy(this.field1172, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1170 += (long)var8;
         }

         if(this.field1164 != -1L) {
            if(this.field1164 > this.field1170 && var3 > 0) {
               var8 = (int)(this.field1164 - this.field1170) + var2;
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1170;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1164 >= var4 && this.field1164 < (long)var7 + var4) {
               var13 = this.field1164;
            } else if(var4 >= this.field1164 && var4 < this.field1164 + (long)this.field1165) {
               var13 = var4;
            }

            if((long)this.field1165 + this.field1164 > var4 && this.field1164 + (long)this.field1165 <= var4 + (long)var7) {
               var10 = this.field1164 + (long)this.field1165;
            } else if(var4 + (long)var7 > this.field1164 && (long)var7 + var4 <= this.field1164 + (long)this.field1165) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1163, (int)(var13 - this.field1164), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1170) {
                  var3 = (int)((long)var3 - (var10 - this.field1170));
                  this.field1170 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1169 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "17"
   )
   void method1440() throws IOException {
      this.field1166 = 0;
      if(this.field1169 != this.field1170) {
         this.field1162.method1467(this.field1170);
         this.field1169 = this.field1170;
      }

      int var1;
      for(this.field1161 = this.field1170; this.field1166 < this.field1172.length; this.field1166 += var1) {
         var1 = this.field1162.method1469(this.field1172, this.field1166, this.field1172.length - this.field1166);
         if(var1 == -1) {
            break;
         }

         this.field1169 += (long)var1;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "282723036"
   )
   void method1442() throws IOException {
      if(this.field1164 != -1L) {
         if(this.field1164 != this.field1169) {
            this.field1162.method1467(this.field1164);
            this.field1169 = this.field1164;
         }

         this.field1162.method1468(this.field1163, 0, this.field1165);
         this.field1169 += -1651148039L * (long)(this.field1165 * 1153705801);
         if(this.field1169 > this.field1167) {
            this.field1167 = this.field1169;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1164 >= this.field1161 && this.field1164 < this.field1161 + (long)this.field1166) {
            var1 = this.field1164;
         } else if(this.field1161 >= this.field1164 && this.field1161 < this.field1164 + (long)this.field1165) {
            var1 = this.field1161;
         }

         if((long)this.field1165 + this.field1164 > this.field1161 && (long)this.field1165 + this.field1164 <= this.field1161 + (long)this.field1166) {
            var3 = this.field1164 + (long)this.field1165;
         } else if(this.field1161 + (long)this.field1166 > this.field1164 && this.field1161 + (long)this.field1166 <= this.field1164 + (long)this.field1165) {
            var3 = (long)this.field1166 + this.field1161;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1163, (int)(var1 - this.field1164), this.field1172, (int)(var1 - this.field1161), var5);
         }

         this.field1164 = -1L;
         this.field1165 = 0;
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-13"
   )
   static final void method1449(int var0, int var1, int var2, int var3) {
      if(Client.field438 == 0 && !Client.field549) {
         class164.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1394; ++var6) {
         var7 = Model.field1395[var6];
         int var18 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && Varbit.region.method1786(class156.plane, var18, var9, var7) >= 0) {
               ObjectComposition var12 = class196.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field438 == 1) {
                  class164.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class187.method3515('\uffff') + var12.name, 1, var7, var18, var9);
               } else if(Client.field549) {
                  if((class137.field1908 & 4) == 4) {
                     class164.addMenuEntry(Client.field328, Client.field350 + " " + "->" + " " + class187.method3515('\uffff') + var12.name, 2, var7, var18, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field456) {
                     var13 = class155.method3078(var13);
                  }

                  if(null != var13) {
                     for(int var21 = 4; var21 >= 0; --var21) {
                        if(var13[var21] != null) {
                           short var15 = 0;
                           if(var21 == 0) {
                              var15 = 3;
                           }

                           if(var21 == 1) {
                              var15 = 4;
                           }

                           if(var21 == 2) {
                              var15 = 5;
                           }

                           if(var21 == 3) {
                              var15 = 6;
                           }

                           if(var21 == 4) {
                              var15 = 1001;
                           }

                           class164.addMenuEntry(var13[var21], class187.method3515('\uffff') + var12.name, var15, var7, var18, var9);
                        }
                     }
                  }

                  class164.addMenuEntry("Examine", class187.method3515('\uffff') + var12.name, 1002, var12.field2928 << 14, var18, var9);
               }
            }

            NPC var14;
            int var19;
            Player var20;
            int[] var27;
            int var29;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3012 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field323; ++var19) {
                     var14 = Client.cachedNPCs[Client.field324[var19]];
                     if(null != var14 && var14 != var23 && var14.composition.field3012 == 1 && var23.x == var14.x && var23.y == var14.y) {
                        Friend.method184(var14.composition, Client.field324[var19], var18, var9);
                     }
                  }

                  var19 = class45.field907;
                  var27 = class45.field900;

                  for(var29 = 0; var29 < var19; ++var29) {
                     var20 = Client.cachedPlayers[var27[var29]];
                     if(var20 != null && var23.x == var20.x && var23.y == var20.y) {
                        Projectile.method861(var20, var27[var29], var18, var9);
                     }
                  }
               }

               Friend.method184(var23.composition, var11, var18, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(null == var24) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field323; ++var19) {
                     var14 = Client.cachedNPCs[Client.field324[var19]];
                     if(null != var14 && var14.composition.field3012 == 1 && var14.x == var24.x && var14.y == var24.y) {
                        Friend.method184(var14.composition, Client.field324[var19], var18, var9);
                     }
                  }

                  var19 = class45.field907;
                  var27 = class45.field900;

                  for(var29 = 0; var29 < var19; ++var29) {
                     var20 = Client.cachedPlayers[var27[var29]];
                     if(var20 != null && var20 != var24 && var20.x == var24.x && var20.y == var24.y) {
                        Projectile.method861(var20, var27[var29], var18, var9);
                     }
                  }
               }

               if(Client.field414 != var11) {
                  Projectile.method861(var24, var11, var18, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class156.plane][var18][var9];
               if(null != var25) {
                  for(Item var26 = (Item)var25.method2476(); null != var26; var26 = (Item)var25.method2475()) {
                     ItemComposition var28 = class168.getItemDefinition(var26.id);
                     if(Client.field438 == 1) {
                        class164.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class187.method3515(16748608) + var28.name, 16, var26.id, var18, var9);
                     } else if(Client.field549) {
                        if((class137.field1908 & 1) == 1) {
                           class164.addMenuEntry(Client.field328, Client.field350 + " " + "->" + " " + class187.method3515(16748608) + var28.name, 17, var26.id, var18, var9);
                        }
                     } else {
                        String[] var22 = var28.groundActions;
                        if(Client.field456) {
                           var22 = class155.method3078(var22);
                        }

                        for(int var16 = 4; var16 >= 0; --var16) {
                           if(null != var22 && null != var22[var16]) {
                              byte var17 = 0;
                              if(var16 == 0) {
                                 var17 = 18;
                              }

                              if(var16 == 1) {
                                 var17 = 19;
                              }

                              if(var16 == 2) {
                                 var17 = 20;
                              }

                              if(var16 == 3) {
                                 var17 = 21;
                              }

                              if(var16 == 4) {
                                 var17 = 22;
                              }

                              class164.addMenuEntry(var22[var16], class187.method3515(16748608) + var28.name, var17, var26.id, var18, var9);
                           } else if(var16 == 2) {
                              class164.addMenuEntry("Take", class187.method3515(16748608) + var28.name, 20, var26.id, var18, var9);
                           }
                        }

                        class164.addMenuEntry("Examine", class187.method3515(16748608) + var28.name, 1004, var26.id, var18, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var8 = Client.cachedPlayers[Client.field414];
         Projectile.method861(var8, Client.field414, var6, var7);
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1162 = var1;
      this.field1159 = this.field1167 = var1.method1470();
      this.field1172 = new byte[var2];
      this.field1163 = new byte[var3];
      this.field1170 = 0L;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-47"
   )
   static final int method1460() {
      if(WallObject.field1551.field689) {
         return class156.plane;
      } else {
         int var0 = class65.method1224(class206.cameraX, class22.cameraY, class156.plane);
         return var0 - class112.cameraZ < 800 && (class10.tileSettings[class156.plane][class206.cameraX >> 7][class22.cameraY >> 7] & 4) != 0?class156.plane:3;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-74"
   )
   public void method1461(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1170 > this.field1159) {
            this.field1159 = (long)var3 + this.field1170;
         }

         if(-1L != this.field1164 && (this.field1170 < this.field1164 || this.field1170 > (long)this.field1165 + this.field1164)) {
            this.method1442();
         }

         if(-1L != this.field1164 && this.field1170 + (long)var3 > (long)this.field1163.length + this.field1164) {
            int var4 = (int)((long)this.field1163.length - (this.field1170 - this.field1164));
            System.arraycopy(var1, var2, this.field1163, (int)(this.field1170 - this.field1164), var4);
            this.field1170 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1165 = this.field1163.length;
            this.method1442();
         }

         if(var3 <= this.field1163.length) {
            if(var3 > 0) {
               if(-1L == this.field1164) {
                  this.field1164 = this.field1170;
               }

               System.arraycopy(var1, var2, this.field1163, (int)(this.field1170 - this.field1164), var3);
               this.field1170 += (long)var3;
               if(this.field1170 - this.field1164 > (long)this.field1165) {
                  this.field1165 = (int)(this.field1170 - this.field1164);
               }

            }
         } else {
            if(this.field1170 != this.field1169) {
               this.field1162.method1467(this.field1170);
               this.field1169 = this.field1170;
            }

            this.field1162.method1468(var1, var2, var3);
            this.field1169 += (long)var3;
            if(this.field1169 > this.field1167) {
               this.field1167 = this.field1169;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1170 >= this.field1161 && this.field1170 < this.field1161 + (long)this.field1166) {
               var9 = this.field1170;
            } else if(this.field1161 >= this.field1170 && this.field1161 < this.field1170 + (long)var3) {
               var9 = this.field1161;
            }

            if((long)var3 + this.field1170 > this.field1161 && (long)var3 + this.field1170 <= (long)this.field1166 + this.field1161) {
               var6 = this.field1170 + (long)var3;
            } else if((long)this.field1166 + this.field1161 > this.field1170 && this.field1161 + (long)this.field1166 <= this.field1170 + (long)var3) {
               var6 = (long)this.field1166 + this.field1161;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.field1170), this.field1172, (int)(var9 - this.field1161), var8);
            }

            this.field1170 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1169 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1869556925"
   )
   public long method1463() {
      return this.field1159;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "491865245"
   )
   static final boolean method1464(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "4"
   )
   static Widget method1465(Widget var0) {
      int var1 = class160.method3144(class8.method112(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class140.method2681(var0.parentId);
            if(null == var0) {
               return null;
            }
         }

         return var0;
      }
   }
}
