import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public final class class29 extends class85 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -669923265
   )
   int field689;
   @ObfuscatedName("l")
   boolean field690 = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2082118349
   )
   int field692;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2059928245
   )
   int field693;
   @ObfuscatedName("y")
   class42 field694;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 805005107
   )
   int field695 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -574773663
   )
   int field696 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -822351409
   )
   int field697;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 83676845
   )
   @Export("cameraPitch")
   static int field698;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = 1326900701
   )
   static int field699;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 476909699
   )
   int field700;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -976465267
   )
   int field704;

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2008376982"
   )
   static final void method664(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field497; ++var4) {
         if(client.field558[var4] + client.field361[var4] > var0 && client.field361[var4] < var0 + var2 && client.field486[var4] + client.field505[var4] > var1 && client.field486[var4] < var1 + var3) {
            client.field499[var4] = true;
         }
      }

   }

   @ObfuscatedName("w")
   final void method665(int var1) {
      if(!this.field690) {
         this.field696 += var1;

         while(this.field696 > this.field694.field997[this.field695]) {
            this.field696 -= this.field694.field997[this.field695];
            ++this.field695;
            if(this.field695 >= this.field694.field995.length) {
               this.field690 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("t")
   protected final class105 vmethod1901() {
      class43 var1 = method669(this.field697);
      class105 var2;
      if(!this.field690) {
         var2 = var1.method937(this.field695);
      } else {
         var2 = var1.method937(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("w")
   public static class43 method669(int var0) {
      class43 var1 = (class43)class43.field1014.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class43.field1020.method3335(13, var0);
         var1 = new class43();
         var1.field1012 = var0;
         if(null != var2) {
            var1.method948(new class119(var2));
         }

         class43.field1014.method3773(var1, (long)var0);
         return var1;
      }
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field697 = var1;
      this.field692 = var2;
      this.field689 = var3;
      this.field700 = var4;
      this.field693 = var5;
      this.field704 = var7 + var6;
      int var8 = method669(this.field697).field1018;
      if(-1 != var8) {
         this.field690 = false;
         this.field694 = class96.method2187(var8);
      } else {
         this.field690 = true;
      }

   }

   @ObfuscatedName("j")
   public static int method670(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("a")
   static void method671() {
      client.field431 = -1L;
      client.field357 = -1;
      class150.field2275.field206 = 0;
      class136.field2103 = true;
      client.field430 = true;
      client.field520 = -1L;
      class134.method2876();
      client.field318.field2011 = 0;
      client.field528.field2011 = 0;
      client.field301 = -1;
      client.field343 = 1;
      client.field344 = -1;
      client.field345 = -1;
      client.field341 = 0;
      client.field394 = 0;
      client.field346 = 0;
      client.field313 = 0;
      client.field435 = 0;
      client.field433 = false;
      class142.method2994(0);
      class11.field188.clear();
      class11.field186.method3821();
      class11.field185.method3869();
      class11.field192 = 0;
      client.field381 = 0;
      client.field573 = false;
      client.field536 = 0;
      client.field358 = (int)(Math.random() * 100.0D) - 50;
      client.field360 = (int)(Math.random() * 110.0D) - 55;
      client.field362 = (int)(Math.random() * 80.0D) - 40;
      client.field365 = (int)(Math.random() * 120.0D) - 60;
      client.field367 = (int)(Math.random() * 30.0D) - 20;
      client.field388 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field334 = 0;
      client.field523 = -1;
      client.field533 = 0;
      client.field529 = 0;
      client.field321 = class20.field586;
      client.field322 = class20.field586;
      client.field332 = 0;
      class131.method2846();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field415[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         client.field331[var0] = null;
      }

      client.field424 = -1;
      client.field427.method3833();
      client.field478.method3833();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               client.field425[var0][var1][var2] = null;
            }
         }
      }

      client.field482 = new class199();
      client.field562 = 0;
      client.field561 = 0;
      client.field565 = 0;

      for(var0 = 0; var0 < class52.field1165; ++var0) {
         class52 var3 = class56.method1237(var0);
         if(null != var3) {
            class176.field2917[var0] = 0;
            class176.field2916[var0] = 0;
         }
      }

      class74.field1375.method230();
      client.field462 = -1;
      if(-1 != client.field454) {
         class48.method1033(client.field454);
      }

      for(class3 var4 = (class3)client.field455.method3805(); var4 != null; var4 = (class3)client.field455.method3809()) {
         class5.method93(var4, true);
      }

      client.field454 = -1;
      client.field455 = new class196(8);
      client.field458 = null;
      client.field433 = false;
      client.field435 = 0;
      client.field309.method3491((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         client.field421[var0] = null;
         client.field422[var0] = false;
      }

      class15.field234 = new class196(32);
      client.field295 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         client.field499[var0] = true;
      }

      class56.method1241();
      client.field338 = null;
      class11.field189 = 0;
      class8.field162 = null;

      for(var0 = 0; var0 < 8; ++var0) {
         client.field570[var0] = new class220();
      }

      class52.field1164 = null;
   }
}
