import java.awt.datatransfer.Clipboard;
import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("IndexData")
public class IndexData extends class182 {
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
      if(null != this.field2755 && null != this.field2750 && this.field2750[var1]) {
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
      if(null != this.field2761) {
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
      if(null != super.field2734[var1]) {
         return 100;
      } else if(this.field2750[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(null != class1.field14 && class1.field14.hash == var4) {
            var2 = 1 + class185.field2775.offset * 99 / (class185.field2775.payload.length - class1.field14.field2721);
         } else {
            var2 = 0;
         }

         return var2;
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
         var3 = 100 * var2 / var1;
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
      } else if(null != super.field2734) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class1.field14 != null && class1.field14.hash == var3) {
            var1 = 1 + class185.field2775.offset * 99 / (class185.field2775.payload.length - class1.field14.field2721);
         } else {
            var1 = 0;
         }

         int var5 = var1;
         if(var1 >= 100) {
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

         if(null == var3) {
            class205.method3844(this, 255, this.index, this.field2756, (byte)0, true);
            return;
         }

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

         if(this.field2756 != var5 || this.field2757 != var8) {
            class205.method3844(this, 255, this.index, this.field2756, (byte)0, true);
            return;
         }

         this.method3391(var3);
         this.method3445();
      } else {
         if(!var4 && this.field2758 == var2) {
            this.field2752 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2750[var2] = false;
            if(this.field2753 || var4) {
               class205.method3844(this, this.index, var2, super.field2724[var2], (byte)2, var4);
            }

            return;
         }

         field2759.reset();
         field2759.update(var3, 0, var3.length - 2);
         var5 = (int)field2759.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.field2724[var2] || var9 != super.field2726[var2]) {
            this.field2750[var2] = false;
            if(this.field2753 || var4) {
               class205.method3844(this, this.index, var2, super.field2724[var2], (byte)2, var4);
            }

            return;
         }

         this.field2750[var2] = true;
         if(var4) {
            super.field2734[var2] = Client.method425(var3, false);
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

      if(null == this.field2755) {
         this.field2752 = true;
      } else {
         this.field2758 = -1;

         for(var1 = 0; var1 < this.field2750.length; ++var1) {
            if(super.field2730[var1] > 0) {
               IndexFile var2 = this.field2755;
               class180 var4 = new class180();
               var4.field2719 = 1;
               var4.hash = (long)var1;
               var4.field2716 = var2;
               var4.field2714 = this;
               Deque var5 = class183.field2746;
               synchronized(class183.field2746) {
                  class183.field2746.method2459(var4);
               }

               Object var10 = class183.field2748;
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
      if(var3) {
         if(this.field2752) {
            throw new RuntimeException();
         }

         if(null != this.field2761) {
            int var5 = this.index;
            IndexFile var6 = this.field2761;
            class180 var7 = new class180();
            var7.field2719 = 0;
            var7.hash = (long)var5;
            var7.field2715 = var2;
            var7.field2716 = var6;
            Deque var8 = class183.field2746;
            synchronized(class183.field2746) {
               class183.field2746.method2459(var7);
            }

            Object var21 = class183.field2748;
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
         if(null != this.field2755) {
            IndexFile var13 = this.field2755;
            class180 var18 = new class180();
            var18.field2719 = 0;
            var18.hash = (long)var1;
            var18.field2715 = var2;
            var18.field2716 = var13;
            Deque var19 = class183.field2746;
            synchronized(class183.field2746) {
               class183.field2746.method2459(var18);
            }

            Object var20 = class183.field2748;
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
         if(null == class146.field2041) {
            class146.field2041 = class216.field3182;
         }

         Client.field522 = class32.field743[class30.field713 + 2];
         Client.secretCipherBuffer1.putOpcode(77);
         Client.secretCipherBuffer1.putByte(Client.field521);
         Client.secretCipherBuffer1.putByte(class146.field2041.field3181);
         Client.secretCipherBuffer1.putByte(Client.field522);
         return 1;
      } else {
         int var4;
         String var16;
         int var18;
         if(var0 == 5002) {
            var16 = class32.scriptStringStack[--class32.scriptStringStackSize];
            class30.field713 -= 2;
            var4 = class32.field743[class30.field713];
            var18 = class32.field743[1 + class30.field713];
            Client.secretCipherBuffer1.putOpcode(208);
            Client.secretCipherBuffer1.putByte(class72.method1439(var16) + 2);
            Client.secretCipherBuffer1.method2931(var16);
            Client.secretCipherBuffer1.putByte(var4 - 1);
            Client.secretCipherBuffer1.putByte(var18);
            return 1;
         } else {
            int var3;
            if(var0 == 5003) {
               class30.field713 -= 2;
               var3 = class32.field743[class30.field713];
               var4 = class32.field743[1 + class30.field713];
               MessageNode var26 = class18.method174(var3, var4);
               if(null != var26) {
                  class32.field743[++class30.field713 - 1] = var26.id;
                  class32.field743[++class30.field713 - 1] = var26.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = null != var26.name?var26.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = null != var26.sender?var26.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = null != var26.value?var26.value:"";
               } else {
                  class32.field743[++class30.field713 - 1] = -1;
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var3 = class32.field743[--class30.field713];
               MessageNode var31 = (MessageNode)class47.field949.method2380((long)var3);
               if(null != var31) {
                  class32.field743[++class30.field713 - 1] = var31.type;
                  class32.field743[++class30.field713 - 1] = var31.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var31.name != null?var31.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = null != var31.sender?var31.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var31.value != null?var31.value:"";
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
            } else if(var0 == 5008) {
               var16 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var4 = class32.field743[--class30.field713];
               String var5 = var16.toLowerCase();
               byte var27 = 0;
               if(var5.startsWith("yellow:")) {
                  var27 = 0;
                  var16 = var16.substring("yellow:".length());
               } else if(var5.startsWith("red:")) {
                  var27 = 1;
                  var16 = var16.substring("red:".length());
               } else if(var5.startsWith("green:")) {
                  var27 = 2;
                  var16 = var16.substring("green:".length());
               } else if(var5.startsWith("cyan:")) {
                  var27 = 3;
                  var16 = var16.substring("cyan:".length());
               } else if(var5.startsWith("purple:")) {
                  var27 = 4;
                  var16 = var16.substring("purple:".length());
               } else if(var5.startsWith("white:")) {
                  var27 = 5;
                  var16 = var16.substring("white:".length());
               } else if(var5.startsWith("flash1:")) {
                  var27 = 6;
                  var16 = var16.substring("flash1:".length());
               } else if(var5.startsWith("flash2:")) {
                  var27 = 7;
                  var16 = var16.substring("flash2:".length());
               } else if(var5.startsWith("flash3:")) {
                  var27 = 8;
                  var16 = var16.substring("flash3:".length());
               } else if(var5.startsWith("glow1:")) {
                  var27 = 9;
                  var16 = var16.substring("glow1:".length());
               } else if(var5.startsWith("glow2:")) {
                  var27 = 10;
                  var16 = var16.substring("glow2:".length());
               } else if(var5.startsWith("glow3:")) {
                  var27 = 11;
                  var16 = var16.substring("glow3:".length());
               } else if(Client.field308 != 0) {
                  if(var5.startsWith("yellow:")) {
                     var27 = 0;
                     var16 = var16.substring("yellow:".length());
                  } else if(var5.startsWith("red:")) {
                     var27 = 1;
                     var16 = var16.substring("red:".length());
                  } else if(var5.startsWith("green:")) {
                     var27 = 2;
                     var16 = var16.substring("green:".length());
                  } else if(var5.startsWith("cyan:")) {
                     var27 = 3;
                     var16 = var16.substring("cyan:".length());
                  } else if(var5.startsWith("purple:")) {
                     var27 = 4;
                     var16 = var16.substring("purple:".length());
                  } else if(var5.startsWith("white:")) {
                     var27 = 5;
                     var16 = var16.substring("white:".length());
                  } else if(var5.startsWith("flash1:")) {
                     var27 = 6;
                     var16 = var16.substring("flash1:".length());
                  } else if(var5.startsWith("flash2:")) {
                     var27 = 7;
                     var16 = var16.substring("flash2:".length());
                  } else if(var5.startsWith("flash3:")) {
                     var27 = 8;
                     var16 = var16.substring("flash3:".length());
                  } else if(var5.startsWith("glow1:")) {
                     var27 = 9;
                     var16 = var16.substring("glow1:".length());
                  } else if(var5.startsWith("glow2:")) {
                     var27 = 10;
                     var16 = var16.substring("glow2:".length());
                  } else if(var5.startsWith("glow3:")) {
                     var27 = 11;
                     var16 = var16.substring("glow3:".length());
                  }
               }

               var5 = var16.toLowerCase();
               byte var28 = 0;
               if(var5.startsWith("wave:")) {
                  var28 = 1;
                  var16 = var16.substring("wave:".length());
               } else if(var5.startsWith("wave2:")) {
                  var28 = 2;
                  var16 = var16.substring("wave2:".length());
               } else if(var5.startsWith("shake:")) {
                  var28 = 3;
                  var16 = var16.substring("shake:".length());
               } else if(var5.startsWith("scroll:")) {
                  var28 = 4;
                  var16 = var16.substring("scroll:".length());
               } else if(var5.startsWith("slide:")) {
                  var28 = 5;
                  var16 = var16.substring("slide:".length());
               } else if(Client.field308 != 0) {
                  if(var5.startsWith("wave:")) {
                     var28 = 1;
                     var16 = var16.substring("wave:".length());
                  } else if(var5.startsWith("wave2:")) {
                     var28 = 2;
                     var16 = var16.substring("wave2:".length());
                  } else if(var5.startsWith("shake:")) {
                     var28 = 3;
                     var16 = var16.substring("shake:".length());
                  } else if(var5.startsWith("scroll:")) {
                     var28 = 4;
                     var16 = var16.substring("scroll:".length());
                  } else if(var5.startsWith("slide:")) {
                     var28 = 5;
                     var16 = var16.substring("slide:".length());
                  }
               }

               Client.secretCipherBuffer1.putOpcode(78);
               Client.secretCipherBuffer1.putByte(0);
               int var8 = Client.secretCipherBuffer1.offset;
               Client.secretCipherBuffer1.putByte(var4);
               Client.secretCipherBuffer1.putByte(var27);
               Client.secretCipherBuffer1.putByte(var28);
               CipherBuffer var9 = Client.secretCipherBuffer1;
               int var19 = var9.offset;
               int var29 = var16.length();
               byte[] var13 = new byte[var29];

               for(int var14 = 0; var14 < var29; ++var14) {
                  char var15 = var16.charAt(var14);
                  if(var15 > 0 && var15 < 128 || var15 >= 160 && var15 <= 255) {
                     var13[var14] = (byte)var15;
                  } else if(var15 == 8364) {
                     var13[var14] = -128;
                  } else if(var15 == 8218) {
                     var13[var14] = -126;
                  } else if(var15 == 402) {
                     var13[var14] = -125;
                  } else if(var15 == 8222) {
                     var13[var14] = -124;
                  } else if(var15 == 8230) {
                     var13[var14] = -123;
                  } else if(var15 == 8224) {
                     var13[var14] = -122;
                  } else if(var15 == 8225) {
                     var13[var14] = -121;
                  } else if(var15 == 710) {
                     var13[var14] = -120;
                  } else if(var15 == 8240) {
                     var13[var14] = -119;
                  } else if(var15 == 352) {
                     var13[var14] = -118;
                  } else if(var15 == 8249) {
                     var13[var14] = -117;
                  } else if(var15 == 338) {
                     var13[var14] = -116;
                  } else if(var15 == 381) {
                     var13[var14] = -114;
                  } else if(var15 == 8216) {
                     var13[var14] = -111;
                  } else if(var15 == 8217) {
                     var13[var14] = -110;
                  } else if(var15 == 8220) {
                     var13[var14] = -109;
                  } else if(var15 == 8221) {
                     var13[var14] = -108;
                  } else if(var15 == 8226) {
                     var13[var14] = -107;
                  } else if(var15 == 8211) {
                     var13[var14] = -106;
                  } else if(var15 == 8212) {
                     var13[var14] = -105;
                  } else if(var15 == 732) {
                     var13[var14] = -104;
                  } else if(var15 == 8482) {
                     var13[var14] = -103;
                  } else if(var15 == 353) {
                     var13[var14] = -102;
                  } else if(var15 == 8250) {
                     var13[var14] = -101;
                  } else if(var15 == 339) {
                     var13[var14] = -100;
                  } else if(var15 == 382) {
                     var13[var14] = -98;
                  } else if(var15 == 376) {
                     var13[var14] = -97;
                  } else {
                     var13[var14] = 63;
                  }
               }

               var9.method2932(var13.length);
               var9.offset += class210.field3133.method2793(var13, 0, var13.length, var9.payload, var9.offset);
               Client.secretCipherBuffer1.method2864(Client.secretCipherBuffer1.offset - var8);
               return 1;
            } else if(var0 == 5009) {
               class32.scriptStringStackSize -= 2;
               var16 = class32.scriptStringStack[class32.scriptStringStackSize];
               String var30 = class32.scriptStringStack[1 + class32.scriptStringStackSize];
               Client.secretCipherBuffer1.putOpcode(238);
               Client.secretCipherBuffer1.putShort(0);
               var18 = Client.secretCipherBuffer1.offset;
               Client.secretCipherBuffer1.method2931(var16);
               CipherBuffer var22 = Client.secretCipherBuffer1;
               int var7 = var22.offset;
               int var23 = var30.length();
               byte[] var10 = new byte[var23];

               for(int var11 = 0; var11 < var23; ++var11) {
                  char var12 = var30.charAt(var11);
                  if((var12 <= 0 || var12 >= 128) && (var12 < 160 || var12 > 255)) {
                     if(var12 == 8364) {
                        var10[var11] = -128;
                     } else if(var12 == 8218) {
                        var10[var11] = -126;
                     } else if(var12 == 402) {
                        var10[var11] = -125;
                     } else if(var12 == 8222) {
                        var10[var11] = -124;
                     } else if(var12 == 8230) {
                        var10[var11] = -123;
                     } else if(var12 == 8224) {
                        var10[var11] = -122;
                     } else if(var12 == 8225) {
                        var10[var11] = -121;
                     } else if(var12 == 710) {
                        var10[var11] = -120;
                     } else if(var12 == 8240) {
                        var10[var11] = -119;
                     } else if(var12 == 352) {
                        var10[var11] = -118;
                     } else if(var12 == 8249) {
                        var10[var11] = -117;
                     } else if(var12 == 338) {
                        var10[var11] = -116;
                     } else if(var12 == 381) {
                        var10[var11] = -114;
                     } else if(var12 == 8216) {
                        var10[var11] = -111;
                     } else if(var12 == 8217) {
                        var10[var11] = -110;
                     } else if(var12 == 8220) {
                        var10[var11] = -109;
                     } else if(var12 == 8221) {
                        var10[var11] = -108;
                     } else if(var12 == 8226) {
                        var10[var11] = -107;
                     } else if(var12 == 8211) {
                        var10[var11] = -106;
                     } else if(var12 == 8212) {
                        var10[var11] = -105;
                     } else if(var12 == 732) {
                        var10[var11] = -104;
                     } else if(var12 == 8482) {
                        var10[var11] = -103;
                     } else if(var12 == 353) {
                        var10[var11] = -102;
                     } else if(var12 == 8250) {
                        var10[var11] = -101;
                     } else if(var12 == 339) {
                        var10[var11] = -100;
                     } else if(var12 == 382) {
                        var10[var11] = -98;
                     } else if(var12 == 376) {
                        var10[var11] = -97;
                     } else {
                        var10[var11] = 63;
                     }
                  } else {
                     var10[var11] = (byte)var12;
                  }
               }

               var22.method2932(var10.length);
               var22.offset += class210.field3133.method2793(var10, 0, var10.length, var22.payload, var22.offset);
               Client.secretCipherBuffer1.method3048(Client.secretCipherBuffer1.offset - var18);
               return 1;
            } else if(var0 != 5015) {
               if(var0 == 5016) {
                  class32.field743[++class30.field713 - 1] = Client.field522;
                  return 1;
               } else if(var0 == 5017) {
                  var3 = class32.field743[--class30.field713];
                  class32.field743[++class30.field713 - 1] = MessageNode.method194(var3);
                  return 1;
               } else if(var0 == 5018) {
                  var3 = class32.field743[--class30.field713];
                  class32.field743[++class30.field713 - 1] = NPC.method749(var3);
                  return 1;
               } else if(var0 == 5019) {
                  var3 = class32.field743[--class30.field713];
                  int[] var17 = class32.field743;
                  var18 = ++class30.field713 - 1;
                  MessageNode var25 = (MessageNode)class47.field949.method2380((long)var3);
                  int var6;
                  if(null == var25) {
                     var6 = -1;
                  } else if(var25.next == class47.field952.field1923) {
                     var6 = -1;
                  } else {
                     var6 = ((MessageNode)var25.next).id;
                  }

                  var17[var18] = var6;
                  return 1;
               } else if(var0 == 5020) {
                  var16 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  class38.method764(var16);
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
                  var16 = Projectile.localPlayer.name;
               } else {
                  var16 = "";
               }

               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var16;
               return 1;
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
