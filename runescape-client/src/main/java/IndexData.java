import java.awt.datatransfer.Clipboard;
import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("pf")
   static Clipboard field2749;
   @ObfuscatedName("c")
   volatile boolean[] field2750;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -714583921
   )
   @Export("index")
   int index;
   @ObfuscatedName("k")
   volatile boolean field2752 = false;
   @ObfuscatedName("t")
   boolean field2753 = false;
   @ObfuscatedName("x")
   IndexFile field2755;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 979742619
   )
   int field2756;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 710433783
   )
   int field2757;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1514842357
   )
   int field2758 = -1;
   @ObfuscatedName("e")
   static CRC32 field2759 = new CRC32();
   @ObfuscatedName("g")
   IndexFile field2761;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2024928714"
   )
   void vmethod3419(int var1) {
      if(this.field2755 != null && this.field2750 != null && this.field2750[var1]) {
         class172.method3305(var1, this.field2755, this);
      } else {
         class205.method3844(this, this.index, var1, super.field2724[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "98"
   )
   void method3420(int var1, int var2) {
      this.field2756 = var1;
      this.field2757 = var2;
      if(this.field2761 != null) {
         class172.method3305(this.index, this.field2761, this);
      } else {
         class205.method3844(this, 255, this.index, this.field2756, (byte)0, true);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void vmethod3422(int var1) {
      class103.method2000(this.index, var1);
   }

   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2755 = var1;
      this.field2761 = var2;
      this.index = var3;
      this.field2753 = var6;
      class173.method3311(this, this.index);
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1204406404"
   )
   int method3423(int var1) {
      if(super.field2734[var1] != null) {
         return 100;
      } else if(this.field2750[var1]) {
         return 100;
      } else {
         int var2 = this.index;
         long var3 = (long)(var1 + (var2 << 16));
         int var5;
         if(class1.field14 != null && class1.field14.hash == var3) {
            var5 = class185.field2775.offset * 99 / (class185.field2775.payload.length - class1.field14.field2721) + 1;
         } else {
            var5 = 0;
         }

         return var5;
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1744390392"
   )
   public int method3424() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2734.length; ++var3) {
         if(super.field2730[var3] > 0) {
            var1 += 100;
            var2 += this.method3423(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1892041348"
   )
   public int method3425() {
      if(this.field2752) {
         return 100;
      } else if(super.field2734 != null) {
         return 99;
      } else {
         int var1 = this.index;
         long var2 = (long)(var1 + 16711680);
         int var4;
         if(class1.field14 != null && class1.field14.hash == var2) {
            var4 = class185.field2775.offset * 99 / (class185.field2775.payload.length - class1.field14.field2721) + 1;
         } else {
            var4 = 0;
         }

         int var5 = var4;
         if(var4 >= 100) {
            var5 = 99;
         }

         return var5;
      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZI)V",
      garbageValue = "159024505"
   )
   public void method3426(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2761) {
         if(this.field2752) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class205.method3844(this, 255, this.index, this.field2756, (byte)0, true);
         } else {
            field2759.reset();
            field2759.update(var3, 0, var3.length);
            var5 = (int)field2759.getValue();
            Buffer var6 = new Buffer(class49.method924(var3));
            int var7 = var6.readUnsignedByte();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.index + "," + var2);
            }

            int var8 = 0;
            if(var7 >= 6) {
               var8 = var6.readInt();
            }

            if(this.field2756 == var5 && this.field2757 == var8) {
               this.method3391(var3);
               this.method3445();
            } else {
               class205.method3844(this, 255, this.index, this.field2756, (byte)0, true);
            }
         }
      } else {
         if(!var4 && this.field2758 == var2) {
            this.field2752 = true;
         }

         if(var3 != null && var3.length > 2) {
            field2759.reset();
            field2759.update(var3, 0, var3.length - 2);
            var5 = (int)field2759.getValue();
            int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if(var5 == super.field2724[var2] && var9 == super.field2726[var2]) {
               this.field2750[var2] = true;
               if(var4) {
                  super.field2734[var2] = Client.method425(var3, false);
               }
            } else {
               this.field2750[var2] = false;
               if(this.field2753 || var4) {
                  class205.method3844(this, this.index, var2, super.field2724[var2], (byte)2, var4);
               }
            }
         } else {
            this.field2750[var2] = false;
            if(this.field2753 || var4) {
               class205.method3844(this, this.index, var2, super.field2724[var2], (byte)2, var4);
            }
         }
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   void method3445() {
      this.field2750 = new boolean[super.field2734.length];

      int var1;
      for(var1 = 0; var1 < this.field2750.length; ++var1) {
         this.field2750[var1] = false;
      }

      if(this.field2755 == null) {
         this.field2752 = true;
      } else {
         this.field2758 = -1;

         for(var1 = 0; var1 < this.field2750.length; ++var1) {
            if(super.field2730[var1] > 0) {
               IndexFile var2 = this.field2755;
               class180 var3 = new class180();
               var3.field2719 = 1;
               var3.hash = (long)var1;
               var3.field2716 = var2;
               var3.field2714 = this;
               Deque var4 = class183.field2746;
               Deque var5 = class183.field2746;
               Deque var6 = class183.field2746;
               synchronized(class183.field2746) {
                  class183.field2746.method2459(var3);
               }

               Object var12 = class183.field2748;
               Object var7 = class183.field2748;
               Object var8 = class183.field2748;
               synchronized(class183.field2748) {
                  if(class183.field2747 == 0) {
                     class108.field1755.method2004(new class183(), 5);
                  }

                  class183.field2747 = 600;
               }

               this.field2758 = var1;
            }
         }

         if(this.field2758 == -1) {
            this.field2752 = true;
         }
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-832943526"
   )
   void method3448(int var1, byte[] var2, boolean var3, boolean var4) {
      Deque var5;
      Object var6;
      Deque var10;
      Object var24;
      if(var3) {
         if(this.field2752) {
            throw new RuntimeException();
         }

         if(this.field2761 != null) {
            int var7 = this.index;
            IndexFile var8 = this.field2761;
            class180 var9 = new class180();
            var9.field2719 = 0;
            var9.hash = (long)var7;
            var9.field2715 = var2;
            var9.field2716 = var8;
            var5 = class183.field2746;
            var10 = class183.field2746;
            Deque var11 = class183.field2746;
            synchronized(class183.field2746) {
               class183.field2746.method2459(var9);
            }

            var6 = class183.field2748;
            var24 = class183.field2748;
            Object var12 = class183.field2748;
            synchronized(class183.field2748) {
               if(class183.field2747 == 0) {
                  class108.field1755.method2004(new class183(), 5);
               }

               class183.field2747 = 600;
            }
         }

         this.method3391(var2);
         this.method3445();
      } else {
         var2[var2.length - 2] = (byte)(super.field2726[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2726[var1];
         if(this.field2755 != null) {
            IndexFile var20 = this.field2755;
            class180 var21 = new class180();
            var21.field2719 = 0;
            var21.hash = (long)var1;
            var21.field2715 = var2;
            var21.field2716 = var20;
            Deque var22 = class183.field2746;
            var5 = class183.field2746;
            var10 = class183.field2746;
            synchronized(class183.field2746) {
               class183.field2746.method2459(var21);
            }

            Object var23 = class183.field2748;
            var6 = class183.field2748;
            var24 = class183.field2748;
            synchronized(class183.field2748) {
               if(class183.field2747 == 0) {
                  class108.field1755.method2004(new class183(), 5);
               }

               class183.field2747 = 600;
            }

            this.field2750[var1] = true;
         }

         if(var4) {
            super.field2734[var1] = Client.method425(var2, false);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-2098017419"
   )
   static int method3450(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class32.field743[++class30.field713 - 1] = Client.field521;
         return 1;
      } else if(var0 == 5001) {
         class30.field713 -= 3;
         Client.field521 = class32.field743[class30.field713];
         class146.field2041 = ItemLayer.method1493(class32.field743[class30.field713 + 1]);
         if(class146.field2041 == null) {
            class146.field2041 = class216.field3182;
         }

         Client.field522 = class32.field743[class30.field713 + 2];
         Client.secretCipherBuffer1.putOpcode(77);
         Client.secretCipherBuffer1.putByte(Client.field521);
         Client.secretCipherBuffer1.putByte(class146.field2041.field3181);
         Client.secretCipherBuffer1.putByte(Client.field522);
         return 1;
      } else {
         int var3;
         String var4;
         int var5;
         if(var0 == 5002) {
            var4 = class32.scriptStringStack[--class32.scriptStringStackSize];
            class30.field713 -= 2;
            var3 = class32.field743[class30.field713];
            var5 = class32.field743[class30.field713 + 1];
            Client.secretCipherBuffer1.putOpcode(208);
            Client.secretCipherBuffer1.putByte(class72.method1439(var4) + 2);
            Client.secretCipherBuffer1.method2931(var4);
            Client.secretCipherBuffer1.putByte(var3 - 1);
            Client.secretCipherBuffer1.putByte(var5);
            return 1;
         } else {
            int var6;
            MessageNode var7;
            if(var0 == 5003) {
               class30.field713 -= 2;
               var6 = class32.field743[class30.field713];
               var3 = class32.field743[class30.field713 + 1];
               var7 = class18.method174(var6, var3);
               if(var7 != null) {
                  class32.field743[++class30.field713 - 1] = var7.id;
                  class32.field743[++class30.field713 - 1] = var7.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.name != null?var7.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.sender != null?var7.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.value != null?var7.value:"";
               } else {
                  class32.field743[++class30.field713 - 1] = -1;
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var6 = class32.field743[--class30.field713];
               var7 = (MessageNode)class47.field949.method2380((long)var6);
               if(var7 != null) {
                  class32.field743[++class30.field713 - 1] = var7.type;
                  class32.field743[++class30.field713 - 1] = var7.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.name != null?var7.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.sender != null?var7.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.value != null?var7.value:"";
               } else {
                  class32.field743[++class30.field713 - 1] = -1;
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5005) {
               if(class146.field2041 == null) {
                  class32.field743[++class30.field713 - 1] = -1;
               } else {
                  class32.field743[++class30.field713 - 1] = class146.field2041.field3181;
               }

               return 1;
            } else {
               int var8;
               int var9;
               String var10;
               if(var0 == 5008) {
                  var4 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  var3 = class32.field743[--class30.field713];
                  var10 = var4.toLowerCase();
                  byte var19 = 0;
                  if(var10.startsWith("yellow:")) {
                     var19 = 0;
                     var4 = var4.substring("yellow:".length());
                  } else if(var10.startsWith("red:")) {
                     var19 = 1;
                     var4 = var4.substring("red:".length());
                  } else if(var10.startsWith("green:")) {
                     var19 = 2;
                     var4 = var4.substring("green:".length());
                  } else if(var10.startsWith("cyan:")) {
                     var19 = 3;
                     var4 = var4.substring("cyan:".length());
                  } else if(var10.startsWith("purple:")) {
                     var19 = 4;
                     var4 = var4.substring("purple:".length());
                  } else if(var10.startsWith("white:")) {
                     var19 = 5;
                     var4 = var4.substring("white:".length());
                  } else if(var10.startsWith("flash1:")) {
                     var19 = 6;
                     var4 = var4.substring("flash1:".length());
                  } else if(var10.startsWith("flash2:")) {
                     var19 = 7;
                     var4 = var4.substring("flash2:".length());
                  } else if(var10.startsWith("flash3:")) {
                     var19 = 8;
                     var4 = var4.substring("flash3:".length());
                  } else if(var10.startsWith("glow1:")) {
                     var19 = 9;
                     var4 = var4.substring("glow1:".length());
                  } else if(var10.startsWith("glow2:")) {
                     var19 = 10;
                     var4 = var4.substring("glow2:".length());
                  } else if(var10.startsWith("glow3:")) {
                     var19 = 11;
                     var4 = var4.substring("glow3:".length());
                  } else if(Client.field308 != 0) {
                     if(var10.startsWith("yellow:")) {
                        var19 = 0;
                        var4 = var4.substring("yellow:".length());
                     } else if(var10.startsWith("red:")) {
                        var19 = 1;
                        var4 = var4.substring("red:".length());
                     } else if(var10.startsWith("green:")) {
                        var19 = 2;
                        var4 = var4.substring("green:".length());
                     } else if(var10.startsWith("cyan:")) {
                        var19 = 3;
                        var4 = var4.substring("cyan:".length());
                     } else if(var10.startsWith("purple:")) {
                        var19 = 4;
                        var4 = var4.substring("purple:".length());
                     } else if(var10.startsWith("white:")) {
                        var19 = 5;
                        var4 = var4.substring("white:".length());
                     } else if(var10.startsWith("flash1:")) {
                        var19 = 6;
                        var4 = var4.substring("flash1:".length());
                     } else if(var10.startsWith("flash2:")) {
                        var19 = 7;
                        var4 = var4.substring("flash2:".length());
                     } else if(var10.startsWith("flash3:")) {
                        var19 = 8;
                        var4 = var4.substring("flash3:".length());
                     } else if(var10.startsWith("glow1:")) {
                        var19 = 9;
                        var4 = var4.substring("glow1:".length());
                     } else if(var10.startsWith("glow2:")) {
                        var19 = 10;
                        var4 = var4.substring("glow2:".length());
                     } else if(var10.startsWith("glow3:")) {
                        var19 = 11;
                        var4 = var4.substring("glow3:".length());
                     }
                  }

                  var10 = var4.toLowerCase();
                  byte var20 = 0;
                  if(var10.startsWith("wave:")) {
                     var20 = 1;
                     var4 = var4.substring("wave:".length());
                  } else if(var10.startsWith("wave2:")) {
                     var20 = 2;
                     var4 = var4.substring("wave2:".length());
                  } else if(var10.startsWith("shake:")) {
                     var20 = 3;
                     var4 = var4.substring("shake:".length());
                  } else if(var10.startsWith("scroll:")) {
                     var20 = 4;
                     var4 = var4.substring("scroll:".length());
                  } else if(var10.startsWith("slide:")) {
                     var20 = 5;
                     var4 = var4.substring("slide:".length());
                  } else if(Client.field308 != 0) {
                     if(var10.startsWith("wave:")) {
                        var20 = 1;
                        var4 = var4.substring("wave:".length());
                     } else if(var10.startsWith("wave2:")) {
                        var20 = 2;
                        var4 = var4.substring("wave2:".length());
                     } else if(var10.startsWith("shake:")) {
                        var20 = 3;
                        var4 = var4.substring("shake:".length());
                     } else if(var10.startsWith("scroll:")) {
                        var20 = 4;
                        var4 = var4.substring("scroll:".length());
                     } else if(var10.startsWith("slide:")) {
                        var20 = 5;
                        var4 = var4.substring("slide:".length());
                     }
                  }

                  Client.secretCipherBuffer1.putOpcode(78);
                  Client.secretCipherBuffer1.putByte(0);
                  var8 = Client.secretCipherBuffer1.offset;
                  Client.secretCipherBuffer1.putByte(var3);
                  Client.secretCipherBuffer1.putByte(var19);
                  Client.secretCipherBuffer1.putByte(var20);
                  CipherBuffer var22 = Client.secretCipherBuffer1;
                  var9 = var22.offset;
                  int var23 = var4.length();
                  byte[] var15 = new byte[var23];

                  for(int var16 = 0; var16 < var23; ++var16) {
                     char var17 = var4.charAt(var16);
                     if((var17 <= 0 || var17 >= 128) && (var17 < 160 || var17 > 255)) {
                        if(var17 == 8364) {
                           var15[var16] = -128;
                        } else if(var17 == 8218) {
                           var15[var16] = -126;
                        } else if(var17 == 402) {
                           var15[var16] = -125;
                        } else if(var17 == 8222) {
                           var15[var16] = -124;
                        } else if(var17 == 8230) {
                           var15[var16] = -123;
                        } else if(var17 == 8224) {
                           var15[var16] = -122;
                        } else if(var17 == 8225) {
                           var15[var16] = -121;
                        } else if(var17 == 710) {
                           var15[var16] = -120;
                        } else if(var17 == 8240) {
                           var15[var16] = -119;
                        } else if(var17 == 352) {
                           var15[var16] = -118;
                        } else if(var17 == 8249) {
                           var15[var16] = -117;
                        } else if(var17 == 338) {
                           var15[var16] = -116;
                        } else if(var17 == 381) {
                           var15[var16] = -114;
                        } else if(var17 == 8216) {
                           var15[var16] = -111;
                        } else if(var17 == 8217) {
                           var15[var16] = -110;
                        } else if(var17 == 8220) {
                           var15[var16] = -109;
                        } else if(var17 == 8221) {
                           var15[var16] = -108;
                        } else if(var17 == 8226) {
                           var15[var16] = -107;
                        } else if(var17 == 8211) {
                           var15[var16] = -106;
                        } else if(var17 == 8212) {
                           var15[var16] = -105;
                        } else if(var17 == 732) {
                           var15[var16] = -104;
                        } else if(var17 == 8482) {
                           var15[var16] = -103;
                        } else if(var17 == 353) {
                           var15[var16] = -102;
                        } else if(var17 == 8250) {
                           var15[var16] = -101;
                        } else if(var17 == 339) {
                           var15[var16] = -100;
                        } else if(var17 == 382) {
                           var15[var16] = -98;
                        } else if(var17 == 376) {
                           var15[var16] = -97;
                        } else {
                           var15[var16] = 63;
                        }
                     } else {
                        var15[var16] = (byte)var17;
                     }
                  }

                  var22.method2932(var15.length);
                  var22.offset += class210.field3133.method2793(var15, 0, var15.length, var22.payload, var22.offset);
                  Client.secretCipherBuffer1.method2864(Client.secretCipherBuffer1.offset - var8);
                  return 1;
               } else {
                  int var11;
                  if(var0 == 5009) {
                     class32.scriptStringStackSize -= 2;
                     var4 = class32.scriptStringStack[class32.scriptStringStackSize];
                     var10 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                     Client.secretCipherBuffer1.putOpcode(238);
                     Client.secretCipherBuffer1.putShort(0);
                     var5 = Client.secretCipherBuffer1.offset;
                     Client.secretCipherBuffer1.method2931(var4);
                     CipherBuffer var18 = Client.secretCipherBuffer1;
                     var11 = var18.offset;
                     var8 = var10.length();
                     byte[] var21 = new byte[var8];

                     for(var9 = 0; var9 < var8; ++var9) {
                        char var14 = var10.charAt(var9);
                        if(var14 > 0 && var14 < 128 || var14 >= 160 && var14 <= 255) {
                           var21[var9] = (byte)var14;
                        } else if(var14 == 8364) {
                           var21[var9] = -128;
                        } else if(var14 == 8218) {
                           var21[var9] = -126;
                        } else if(var14 == 402) {
                           var21[var9] = -125;
                        } else if(var14 == 8222) {
                           var21[var9] = -124;
                        } else if(var14 == 8230) {
                           var21[var9] = -123;
                        } else if(var14 == 8224) {
                           var21[var9] = -122;
                        } else if(var14 == 8225) {
                           var21[var9] = -121;
                        } else if(var14 == 710) {
                           var21[var9] = -120;
                        } else if(var14 == 8240) {
                           var21[var9] = -119;
                        } else if(var14 == 352) {
                           var21[var9] = -118;
                        } else if(var14 == 8249) {
                           var21[var9] = -117;
                        } else if(var14 == 338) {
                           var21[var9] = -116;
                        } else if(var14 == 381) {
                           var21[var9] = -114;
                        } else if(var14 == 8216) {
                           var21[var9] = -111;
                        } else if(var14 == 8217) {
                           var21[var9] = -110;
                        } else if(var14 == 8220) {
                           var21[var9] = -109;
                        } else if(var14 == 8221) {
                           var21[var9] = -108;
                        } else if(var14 == 8226) {
                           var21[var9] = -107;
                        } else if(var14 == 8211) {
                           var21[var9] = -106;
                        } else if(var14 == 8212) {
                           var21[var9] = -105;
                        } else if(var14 == 732) {
                           var21[var9] = -104;
                        } else if(var14 == 8482) {
                           var21[var9] = -103;
                        } else if(var14 == 353) {
                           var21[var9] = -102;
                        } else if(var14 == 8250) {
                           var21[var9] = -101;
                        } else if(var14 == 339) {
                           var21[var9] = -100;
                        } else if(var14 == 382) {
                           var21[var9] = -98;
                        } else if(var14 == 376) {
                           var21[var9] = -97;
                        } else {
                           var21[var9] = 63;
                        }
                     }

                     var18.method2932(var21.length);
                     var18.offset += class210.field3133.method2793(var21, 0, var21.length, var18.payload, var18.offset);
                     Client.secretCipherBuffer1.method3048(Client.secretCipherBuffer1.offset - var5);
                     return 1;
                  } else if(var0 != 5015) {
                     if(var0 == 5016) {
                        class32.field743[++class30.field713 - 1] = Client.field522;
                        return 1;
                     } else if(var0 == 5017) {
                        var6 = class32.field743[--class30.field713];
                        class32.field743[++class30.field713 - 1] = MessageNode.method194(var6);
                        return 1;
                     } else if(var0 == 5018) {
                        var6 = class32.field743[--class30.field713];
                        class32.field743[++class30.field713 - 1] = NPC.method749(var6);
                        return 1;
                     } else if(var0 == 5019) {
                        var6 = class32.field743[--class30.field713];
                        int[] var12 = class32.field743;
                        var5 = ++class30.field713 - 1;
                        MessageNode var13 = (MessageNode)class47.field949.method2380((long)var6);
                        if(var13 == null) {
                           var11 = -1;
                        } else if(var13.next == class47.field952.field1923) {
                           var11 = -1;
                        } else {
                           var11 = ((MessageNode)var13.next).id;
                        }

                        var12[var5] = var11;
                        return 1;
                     } else if(var0 == 5020) {
                        var4 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        class38.method764(var4);
                        return 1;
                     } else if(var0 == 5021) {
                        Client.field472 = class32.scriptStringStack[--class32.scriptStringStackSize].toLowerCase().trim();
                        return 1;
                     } else if(var0 == 5022) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.field472;
                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     if(Projectile.localPlayer != null && Projectile.localPlayer.name != null) {
                        var4 = Projectile.localPlayer.name;
                     } else {
                        var4 = "";
                     }

                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2014238545"
   )
   static void method3451(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3233 = var1.readUnsignedShort();
      class225.field3230 = new int[class225.field3233];
      ItemComposition.field3003 = new int[class225.field3233];
      class225.field3232 = new int[class225.field3233];
      ChatLineBuffer.field994 = new int[class225.field3233];
      BufferProvider.field3199 = new byte[class225.field3233][];
      var1.offset = var0.length - 7 - class225.field3233 * 8;
      class225.field3231 = var1.readUnsignedShort();
      class146.field2038 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3233; ++var3) {
         class225.field3230[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         ItemComposition.field3003[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         class225.field3232[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         ChatLineBuffer.field994[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3233 * 8 - (var2 - 1) * 3;
      class225.field3234 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3234[var3] = var1.read24BitInt();
         if(class225.field3234[var3] == 0) {
            class225.field3234[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         int var4 = class225.field3232[var3];
         int var5 = ChatLineBuffer.field994[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         BufferProvider.field3199[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.readByte();
               }
            }
         }
      }

   }
}
