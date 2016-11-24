import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 3512056794721512493L
   )
   long field912;
   @ObfuscatedName("m")
   boolean[] field914;
   @ObfuscatedName("c")
   boolean field916 = false;
   @ObfuscatedName("r")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("w")
   int[] field921;
   @ObfuscatedName("h")
   boolean[] field923;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2107499369"
   )
   void method846(int var1, int var2) {
      this.field921[var1] = var2;
      if(this.field914[var1]) {
         this.field916 = true;
      }

   }

   ChatMessages() {
      this.field921 = new int[class143.field2015.method3339(19)];
      this.messages = new String[class143.field2015.method3339(15)];
      this.field914 = new boolean[this.field921.length];

      int var1;
      for(var1 = 0; var1 < this.field921.length; ++var1) {
         class188 var2 = class177.method3311(var1);
         this.field914[var1] = var2.field2781;
      }

      this.field923 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var3 = (class189)class189.field2787.get((long)var1);
         class189 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class189.field2789.method3329(15, var1);
            var3 = new class189();
            if(var4 != null) {
               var3.method3505(new Buffer(var4));
            }

            class189.field2787.put(var3, (long)var1);
            var5 = var3;
         }

         this.field923[var1] = var5.field2786;
      }

      for(var1 = 0; var1 < this.field921.length; ++var1) {
         this.field921[var1] = -1;
      }

      this.method868();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1594772272"
   )
   void method849() {
      int var1;
      for(var1 = 0; var1 < this.field921.length; ++var1) {
         if(!this.field914[var1]) {
            this.field921[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field923[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZB)LFileOnDisk;",
      garbageValue = "18"
   )
   FileOnDisk method850(boolean var1) {
      return class118.method2341("2", NPC.field758.field2696, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "751656110"
   )
   void method851() {
      FileOnDisk var1 = this.method850(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field921.length; ++var4) {
            if(this.field914[var4] && this.field921[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field923[var5] && null != this.messages[var5]) {
               var2 += 2 + RSCanvas.method2132(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2975(1);
         var9.method2976(var3);

         int var6;
         for(var6 = 0; var6 < this.field921.length; ++var6) {
            if(this.field914[var6] && this.field921[var6] != -1) {
               var9.method2976(var6);
               var9.method2978(this.field921[var6]);
            }
         }

         var9.method2976(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field923[var6] && null != this.messages[var6]) {
               var9.method2976(var6);
               var9.method2981(this.messages[var6]);
            }
         }

         var1.method1441(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1442();
         } catch (Exception var16) {
            ;
         }

      }

      this.field916 = false;
      this.field912 = class202.method3838();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   String method852(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1423382813"
   )
   void method853() {
      if(this.field916 && this.field912 < class202.method3838() - 60000L) {
         this.method851();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1465008898"
   )
   int method862(int var1) {
      return this.field921[var1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "36"
   )
   void method868() {
      FileOnDisk var1 = this.method850(false);

      label203: {
         try {
            byte[] var2 = new byte[(int)var1.method1439()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method1444(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.method3033();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method3097();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method3097();
                  var9 = var13.method2995();
                  if(this.field914[var8]) {
                     this.field921[var8] = var9;
                  }
               }

               var7 = var13.method3097();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label203;
                  }

                  var9 = var13.method3097();
                  String var10 = var13.method3057();
                  if(this.field923[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label203;
         } finally {
            try {
               var1.method1442();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field916 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1170761898"
   )
   void method870(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field923[var1]) {
         this.field916 = true;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-547111025"
   )
   boolean method877() {
      return this.field916;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1366569164"
   )
   public static boolean method879(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
