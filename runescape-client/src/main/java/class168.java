import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class168 extends class167 {
   @ObfuscatedName("w")
   class134 field2698;
   @ObfuscatedName("g")
   class134 field2699;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 727566581
   )
   int field2700;
   @ObfuscatedName("f")
   volatile boolean field2701 = false;
   @ObfuscatedName("n")
   volatile boolean[] field2703;
   @ObfuscatedName("v")
   static CRC32 field2704 = new CRC32();
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2098776339
   )
   int field2705;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1012535625
   )
   int field2706;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 884406927
   )
   int field2707 = -1;
   @ObfuscatedName("q")
   boolean field2709 = false;

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2698 = var1;
      this.field2699 = var2;
      this.field2700 = var3;
      this.field2709 = var6;
      int var7 = this.field2700;
      if(class171.field2742 != null) {
         class171.field2742.field2005 = var7 * 8 + 5;
         int var8 = class171.field2742.method2497();
         int var9 = class171.field2742.method2497();
         this.method3313(var8, var9);
      } else {
         class94.method2146((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2746[var7] = this;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2125267106"
   )
   void vmethod3311(int var1) {
      int var2 = this.field2700;
      long var3 = (long)((var2 << 16) + var1);
      class172 var5 = (class172)class171.field2734.method3777(var3);
      if(null != var5) {
         class171.field2743.method3861(var5);
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "56"
   )
   void method3313(int var1, int var2) {
      this.field2705 = var1;
      this.field2706 = var2;
      if(null != this.field2699) {
         class16.method199(this.field2700, this.field2699, this);
      } else {
         class94.method2146(this, 255, this.field2700, this.field2705, (byte)0, true);
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1"
   )
   void method3314(int var1, byte[] var2, boolean var3, boolean var4) {
      if(this.field2701) {
         throw new RuntimeException();
      } else {
         if(this.field2699 != null) {
            int var5 = this.field2700;
            class134 var6 = this.field2699;
            class169 var7 = new class169();
            var7.field2712 = 0;
            var7.field3125 = (long)var5;
            var7.field2714 = var2;
            var7.field2713 = var6;
            class199 var8 = class170.field2722;
            class199 var9 = class170.field2722;
            synchronized(class170.field2722) {
               class170.field2722.method3807(var7);
            }

            Object var14 = class170.field2723;
            Object var10 = class170.field2723;
            synchronized(class170.field2723) {
               if(class170.field2721 == 0) {
                  class38.field878.method2862(new class170(), 5);
               }

               class170.field2721 = 600;
            }
         }

         this.method3279(var2);
         this.method3316();
      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1033446065"
   )
   void method3316() {
      this.field2703 = new boolean[super.field2687.length];

      int var1;
      for(var1 = 0; var1 < this.field2703.length; ++var1) {
         this.field2703[var1] = false;
      }

      if(this.field2698 == null) {
         this.field2701 = true;
      } else {
         this.field2707 = -1;

         for(var1 = 0; var1 < this.field2703.length; ++var1) {
            if(super.field2696[var1] > 0) {
               class14.method174(var1, this.field2698, this);
               this.field2707 = var1;
            }
         }

         if(-1 == this.field2707) {
            this.field2701 = true;
         }
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   int method3317(int var1) {
      return super.field2687[var1] != null?100:(this.field2703[var1]?100:class76.method1642(this.field2700, var1));
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1778104313"
   )
   public int method3323() {
      if(this.field2701) {
         return 100;
      } else if(super.field2687 != null) {
         return 99;
      } else {
         int var1 = this.field2700;
         long var2 = (long)(16711680 + var1);
         int var4;
         if(null != class124.field2045 && var2 == class124.field2045.field3125) {
            var4 = class171.field2735.field2005 * 99 / (class171.field2735.field2007.length - class124.field2045.field2750) + 1;
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "207"
   )
   void vmethod3324(int var1) {
      if(this.field2698 != null && this.field2703 != null && this.field2703[var1]) {
         class16.method199(var1, this.field2698, this);
      } else {
         class94.method2146(this, this.field2700, var1, super.field2684[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1783754713"
   )
   static final void method3328() {
      class46.field1063.method3750();
      class43.method877();
      class44.field1025.method3750();
      class169.method3342();
      class174.method3422();
      class51.field1140.method3750();
      class51.field1131.method3750();
      class51.field1113.method3750();
      class113.method2435();
      class3.method37();
      class47.field1065.method3750();
      class48.method972();
      class111.method2419();
      class173.field2759.method3750();
      class173.field2760.method3750();
      class173.field2857.method3750();
      class173.field2762.method3750();
      ((class95)class91.field1593).method2160();
      class22.field589.method3750();
      class14.field199.method3252();
      class115.field1988.method3252();
      class174.field2905.method3252();
      class28.field682.method3252();
      class7.field132.method3252();
      class102.field1776.method3252();
      class15.field212.method3252();
      class127.field2058.method3252();
      class96.field1644.method3252();
      class164.field2663.method3252();
      class3.field65.method3252();
      class9.field155.method3252();
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZB)V",
      garbageValue = "0"
   )
   void method3333(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2699) {
         if(this.field2701) {
            throw new RuntimeException();
         } else if(null == var3) {
            class94.method2146(this, 255, this.field2700, this.field2705, (byte)0, true);
         } else {
            field2704.reset();
            field2704.update(var3, 0, var3.length);
            var5 = (int)field2704.getValue();
            class119 var9 = new class119(class17.method205(var3));
            int var7 = var9.method2492();
            if(5 != var7 && 6 != var7) {
               throw new RuntimeException(var7 + "," + this.field2700 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var9.method2497();
               }

               if(this.field2705 != var5 || this.field2706 != var8) {
                  class94.method2146(this, 255, this.field2700, this.field2705, (byte)0, true);
               } else {
                  this.method3279(var3);
                  this.method3316();
               }
            }
         }
      } else {
         if(!var4 && this.field2707 == var2) {
            this.field2701 = true;
         }

         if(var3 != null && var3.length > 2) {
            field2704.reset();
            field2704.update(var3, 0, var3.length - 2);
            var5 = (int)field2704.getValue();
            int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(var5 == super.field2684[var2] && var6 == super.field2682[var2]) {
               this.field2703[var2] = true;
               if(var4) {
                  super.field2687[var2] = class148.method3115(var3, false);
               }

            } else {
               this.field2703[var2] = false;
               if(this.field2709 || var4) {
                  class94.method2146(this, this.field2700, var2, super.field2684[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2703[var2] = false;
            if(this.field2709 || var4) {
               class94.method2146(this, this.field2700, var2, super.field2684[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-204921535"
   )
   public int method3334() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2687.length; ++var3) {
         if(super.field2696[var3] > 0) {
            var1 += 100;
            var2 += this.method3317(var3);
         }
      }

      if(0 == var1) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }
}
