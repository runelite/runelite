import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class48 extends class204 {
   @ObfuscatedName("g")
   public char field1084;
   @ObfuscatedName("h")
   public char field1085;
   @ObfuscatedName("z")
   public String field1086 = "null";
   @ObfuscatedName("i")
   public static class193 field1087 = new class193(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1889613495
   )
   public int field1088 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -291207601
   )
   public int field1089;
   @ObfuscatedName("d")
   public int[] field1090;
   @ObfuscatedName("l")
   public String[] field1091;
   @ObfuscatedName("s")
   public int[] field1093;
   @ObfuscatedName("eb")
   static class78[] field1094;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 251865905
   )
   static int field1096;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2047423275"
   )
   public void method963(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method964(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-80"
   )
   void method964(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1084 = (char)var1.method2494();
      } else if(var2 == 2) {
         this.field1085 = (char)var1.method2494();
      } else if(var2 == 3) {
         this.field1086 = var1.method2476();
      } else if(var2 == 4) {
         this.field1089 = var1.method2505();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1088 = var1.method2470();
            this.field1093 = new int[this.field1088];
            this.field1091 = new String[this.field1088];

            for(var3 = 0; var3 < this.field1088; ++var3) {
               this.field1093[var3] = var1.method2505();
               this.field1091[var3] = var1.method2476();
            }
         } else if(var2 == 6) {
            this.field1088 = var1.method2470();
            this.field1093 = new int[this.field1088];
            this.field1090 = new int[this.field1088];

            for(var3 = 0; var3 < this.field1088; ++var3) {
               this.field1093[var3] = var1.method2505();
               this.field1090[var3] = var1.method2505();
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "-2134716115"
   )
   public static void method967(class167 var0) {
      class47.field1076 = var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lclass50;",
      garbageValue = "1929467688"
   )
   public static class50 method969(int var0) {
      class50 var1 = (class50)class50.field1106.method3716((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class50.field1109.method3221(5, var0);
         var1 = new class50();
         if(null != var2) {
            var1.method985(new class119(var2));
         }

         class50.field1106.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   static final void method970(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-457118322"
   )
   static int method972(int var0, int var1) {
      class15 var2 = (class15)class15.field222.method3748((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.field221.length; ++var4) {
            if(var2.field220[var4] == var1) {
               var3 += var2.field221[var4];
            }
         }

         return var3;
      }
   }
}
