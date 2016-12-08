import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("d")
   static int[] field918;
   @ObfuscatedName("b")
   boolean[] field920;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 4409427776882643165L
   )
   long field921;
   @ObfuscatedName("h")
   int[] field922;
   @ObfuscatedName("v")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("l")
   boolean field924 = false;
   @ObfuscatedName("cu")
   static class102 field926;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 779881395
   )
   static int field928;
   @ObfuscatedName("ag")
   static int[] field931;
   @ObfuscatedName("j")
   public static class60 field932;
   @ObfuscatedName("g")
   boolean[] field933;
   @ObfuscatedName("al")
   @Export("authCode")
   static String authCode;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "957078740"
   )
   FileOnDisk method821(boolean var1) {
      return class33.method676("2", class145.field2024.field2700, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1357029410"
   )
   void method822() {
      FileOnDisk var1 = this.method821(false);

      label203: {
         try {
            byte[] var2 = new byte[(int)var1.method1389()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method1391(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.readUnsignedByte();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.readUnsignedShort();
                  var9 = var13.method2731();
                  if(this.field920[var8]) {
                     this.field922[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label203;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.method2780();
                  if(this.field933[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label203;
         } finally {
            try {
               var1.method1400();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field924 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "211743356"
   )
   int method823(int var1) {
      return this.field922[var1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2087320697"
   )
   void method824() {
      if(this.field924 && this.field921 < class114.method2154() - 60000L) {
         this.method827();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   String method825(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method826() {
      int var1;
      for(var1 = 0; var1 < this.field922.length; ++var1) {
         if(!this.field920[var1]) {
            this.field922[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field933[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1016454351"
   )
   void method827() {
      FileOnDisk var1 = this.method821(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field922.length; ++var4) {
            if(this.field920[var4] && this.field922[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field933[var5] && this.messages[var5] != null) {
               var2 += 2 + class112.method2050(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2815(1);
         var9.method2712(var3);

         int var6;
         for(var6 = 0; var6 < this.field922.length; ++var6) {
            if(this.field920[var6] && this.field922[var6] != -1) {
               var9.method2712(var6);
               var9.method2714(this.field922[var6]);
            }
         }

         var9.method2712(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field933[var6] && this.messages[var6] != null) {
               var9.method2712(var6);
               var9.method2717(this.messages[var6]);
            }
         }

         var1.method1387(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1400();
         } catch (Exception var16) {
            ;
         }

      }

      this.field924 = false;
      this.field921 = class114.method2154();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1268303917"
   )
   boolean method828() {
      return this.field924;
   }

   ChatMessages() {
      this.field922 = new int[class165.field2178.method3245(19)];
      this.messages = new String[class165.field2178.method3245(15)];
      this.field920 = new boolean[this.field922.length];

      int var1;
      for(var1 = 0; var1 < this.field922.length; ++var1) {
         class188 var3 = (class188)class188.field2786.get((long)var1);
         class188 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class188.field2787.method3203(19, var1);
            var3 = new class188();
            if(var4 != null) {
               var3.method3358(new Buffer(var4));
            }

            class188.field2786.put(var3, (long)var1);
            var2 = var3;
         }

         this.field920[var1] = var2.field2785;
      }

      this.field933 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var5 = class36.method712(var1);
         this.field933[var1] = var5.field2788;
      }

      for(var1 = 0; var1 < this.field922.length; ++var1) {
         this.field922[var1] = -1;
      }

      this.method822();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "0"
   )
   void method835(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field933[var1]) {
         this.field924 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1077401179"
   )
   void method837(int var1, int var2) {
      this.field922[var1] = var2;
      if(this.field920[var1]) {
         this.field924 = true;
      }

   }
}
