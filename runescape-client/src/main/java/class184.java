import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class184 extends class182 {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1335259597
   )
   int field2727;
   @ObfuscatedName("t")
   class116 field2728;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -115801289
   )
   int field2729;
   @ObfuscatedName("p")
   volatile boolean field2730 = false;
   @ObfuscatedName("o")
   static CRC32 field2731 = new CRC32();
   @ObfuscatedName("a")
   volatile boolean[] field2732;
   @ObfuscatedName("n")
   boolean field2733 = false;
   @ObfuscatedName("b")
   class116 field2734;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2142222787
   )
   int field2735;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -443877569
   )
   int field2736 = -1;

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZB)V",
      garbageValue = "16"
   )
   void method3405(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2728) {
         if(this.field2730) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class31.method704(this, 255, this.field2729, this.field2735, (byte)0, true);
            return;
         }

         field2731.reset();
         field2731.update(var3, 0, var3.length);
         var5 = (int)field2731.getValue();
         Buffer var6 = new Buffer(class7.method93(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2729 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.readInt();
         }

         if(var5 != this.field2735 || var8 != this.field2727) {
            class31.method704(this, 255, this.field2729, this.field2735, (byte)0, true);
            return;
         }

         this.method3358(var3);
         this.method3430();
      } else {
         if(!var4 && var2 == this.field2736) {
            this.field2730 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2732[var2] = false;
            if(this.field2733 || var4) {
               class31.method704(this, this.field2729, var2, super.field2701[var2], (byte)2, var4);
            }

            return;
         }

         field2731.reset();
         field2731.update(var3, 0, var3.length - 2);
         var5 = (int)field2731.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(super.field2701[var2] != var5 || super.field2713[var2] != var9) {
            this.field2732[var2] = false;
            if(this.field2733 || var4) {
               class31.method704(this, this.field2729, var2, super.field2701[var2], (byte)2, var4);
            }

            return;
         }

         this.field2732[var2] = true;
         if(var4) {
            super.field2707[var2] = class38.method813(var3, false);
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "29"
   )
   public int method3406() {
      if(this.field2730) {
         return 100;
      } else if(null != super.field2707) {
         return 99;
      } else {
         int var2 = this.field2729;
         long var5 = (long)(var2 + 16711680);
         int var1;
         if(FloorUnderlayDefinition.field2808 != null && var5 == FloorUnderlayDefinition.field2808.hash) {
            var1 = 1 + class72.field1196.offset * 99 / (class72.field1196.payload.length - FloorUnderlayDefinition.field2808.field2694);
         } else {
            var1 = 0;
         }

         int var3 = var1;
         if(var1 >= 100) {
            var3 = 99;
         }

         return var3;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2132467277"
   )
   void vmethod3407(int var1) {
      int var2 = this.field2729;
      long var3 = (long)((var2 << 16) + var1);
      class181 var5 = (class181)class185.field2757.method2405(var3);
      if(null != var5) {
         class185.field2747.method2336(var5);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "505541502"
   )
   void vmethod3408(int var1) {
      if(this.field2734 != null && null != this.field2732 && this.field2732[var1]) {
         class148.method2793(var1, this.field2734, this);
      } else {
         class31.method704(this, this.field2729, var1, super.field2701[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1072591374"
   )
   public void method3409(int var1, int var2) {
      this.field2735 = var1;
      this.field2727 = var2;
      if(this.field2728 != null) {
         class148.method2793(this.field2729, this.field2728, this);
      } else {
         class31.method704(this, 255, this.field2729, this.field2735, (byte)0, true);
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "903443054"
   )
   public void method3410(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2730) {
            throw new RuntimeException();
         }

         if(this.field2728 != null) {
            XClanMember.method275(this.field2729, var2, this.field2728);
         }

         this.method3358(var2);
         this.method3430();
      } else {
         var2[var2.length - 2] = (byte)(super.field2713[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2713[var1];
         if(null != this.field2734) {
            XClanMember.method275(var1, var2, this.field2734);
            this.field2732[var1] = true;
         }

         if(var4) {
            super.field2707[var1] = class38.method813(var2, false);
         }
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-709027823"
   )
   int method3413(int var1) {
      if(super.field2707[var1] != null) {
         return 100;
      } else if(this.field2732[var1]) {
         return 100;
      } else {
         int var3 = this.field2729;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(FloorUnderlayDefinition.field2808 != null && var4 == FloorUnderlayDefinition.field2808.hash) {
            var2 = class72.field1196.offset * 99 / (class72.field1196.payload.length - FloorUnderlayDefinition.field2808.field2694) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "67"
   )
   public int method3419() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2707.length; ++var3) {
         if(super.field2703[var3] > 0) {
            var1 += 100;
            var2 += this.method3413(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-378102888"
   )
   static final void method3425(String var0) {
      if(null != var0) {
         String var1 = GroundObject.method1598(var0, class165.field2155);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = GroundObject.method1598(var4, class165.field2155);
               boolean var6;
               if(var0 != null && null != var4) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[1 + var7];
                  }

                  Client.field506 = Client.field498;
                  Client.field309.method3076(237);
                  Client.field309.putByte(class164.method3157(var0));
                  Client.field309.method2822(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-123"
   )
   void method3430() {
      this.field2732 = new boolean[super.field2707.length];

      int var1;
      for(var1 = 0; var1 < this.field2732.length; ++var1) {
         this.field2732[var1] = false;
      }

      if(this.field2734 == null) {
         this.field2730 = true;
      } else {
         this.field2736 = -1;

         for(var1 = 0; var1 < this.field2732.length; ++var1) {
            if(super.field2703[var1] > 0) {
               class116 var2 = this.field2734;
               class180 var4 = new class180();
               var4.field2690 = 1;
               var4.hash = (long)var1;
               var4.field2683 = var2;
               var4.field2685 = this;
               Deque var5 = class183.field2719;
               synchronized(class183.field2719) {
                  class183.field2719.method2458(var4);
               }

               class99.method2006();
               this.field2736 = var1;
            }
         }

         if(this.field2736 == -1) {
            this.field2730 = true;
         }

      }
   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2734 = var1;
      this.field2728 = var2;
      this.field2729 = var3;
      this.field2733 = var6;
      Renderable.method1949(this, this.field2729);
   }
}
