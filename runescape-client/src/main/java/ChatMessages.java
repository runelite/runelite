import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -1343389833
   )
   static int field1500;
   @ObfuscatedName("u")
   boolean[] field1502;
   @ObfuscatedName("q")
   boolean[] field1503;
   @ObfuscatedName("g")
   int[] field1504;
   @ObfuscatedName("cc")
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("t")
   boolean field1506;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -1272948387
   )
   static int field1510;
   @ObfuscatedName("v")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -4890995870789552537L
   )
   long field1512;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2005538803
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "959407056"
   )
   void method1822(int var1, int var2) {
      this.field1504[var1] = var2;
      if(this.field1502[var1]) {
         this.field1506 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-121604322"
   )
   int method1823(int var1) {
      return this.field1504[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-826220081"
   )
   void method1826() {
      int var1;
      for(var1 = 0; var1 < this.field1504.length; ++var1) {
         if(!this.field1502[var1]) {
            this.field1504[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field1503[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-779219492"
   )
   FileOnDisk method1827(boolean var1) {
      return XGrandExchangeOffer.getPreferencesFile("2", class4.field25.name, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-131274565"
   )
   void method1828() {
      FileOnDisk var1 = this.method1827(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field1504.length; ++var4) {
            if(this.field1502[var4] && this.field1504[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field1503[var5] && this.messages[var5] != null) {
               var2 += class46.method711(this.messages[var5]) + 2;
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.field1504.length; ++var6) {
            if(this.field1502[var6] && this.field1504[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.field1504[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field1503[var6] && this.messages[var6] != null) {
               var9.putShort(var6);
               var9.method3191(this.messages[var6]);
            }
         }

         var1.method2384(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method2385();
         } catch (Exception var16) {
            ;
         }

      }

      this.field1506 = false;
      this.field1512 = class226.method4147();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1392277160"
   )
   void method1829() {
      FileOnDisk var1 = this.method1827(false);

      label190: {
         try {
            byte[] var2 = new byte[(int)var1.method2386()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method2387(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset >= 1) {
               int var14 = var13.readUnsignedByte();
               if(var14 < 0 || var14 > 1) {
                  return;
               }

               int var15 = var13.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.readUnsignedShort();
                  var9 = var13.readInt();
                  if(this.field1502[var8]) {
                     this.field1504[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label190;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.field1503[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label190;
         } finally {
            try {
               var1.method2385();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field1506 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-840725854"
   )
   void method1830() {
      if(this.field1506 && this.field1512 < class226.method4147() - 60000L) {
         this.method1828();
      }

   }

   ChatMessages() {
      this.field1506 = false;
      this.field1504 = new int[class17.field311.method4184(19)];
      this.messages = new String[class17.field311.method4184(15)];
      this.field1502 = new boolean[this.field1504.length];

      int var1;
      for(var1 = 0; var1 < this.field1504.length; ++var1) {
         class243 var3 = (class243)class243.field3303.get((long)var1);
         class243 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class243.field3302.getConfigData(19, var1);
            var3 = new class243();
            if(var4 != null) {
               var3.method4389(new Buffer(var4));
            }

            class243.field3303.put(var3, (long)var1);
            var2 = var3;
         }

         this.field1502[var1] = var2.field3304;
      }

      this.field1503 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class244 var5 = IndexDataBase.method4271(var1);
         this.field1503[var1] = var5.field3309;
      }

      for(var1 = 0; var1 < this.field1504.length; ++var1) {
         this.field1504[var1] = -1;
      }

      this.method1829();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-30"
   )
   String method1831(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1582670476"
   )
   boolean method1843() {
      return this.field1506;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "123"
   )
   void method1852(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field1503[var1]) {
         this.field1506 = true;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass119;S)V",
      garbageValue = "9295"
   )
   static final void method1854(class119 var0) {
      var0.field1703 = false;
      if(var0.field1705 != null) {
         var0.field1705.field1737 = 0;
      }

      for(class119 var1 = var0.vmethod3944(); var1 != null; var1 = var0.vmethod3945()) {
         method1854(var1);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;I)V",
      garbageValue = "-1138065804"
   )
   static final void method1855(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var1 + var7 < 103 && var8 + var2 > 0 && var2 + var8 < 103) {
                  var5[var6].flags[var1 + var7][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class146.method2936(var10, var7, var8 + var1, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}
