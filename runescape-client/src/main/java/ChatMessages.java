import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("e")
   boolean[] field1519;
   @ObfuscatedName("v")
   boolean[] field1521;
   @ObfuscatedName("b")
   int[] field1522;
   @ObfuscatedName("y")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("h")
   boolean field1524;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -6773668733787133431L
   )
   long field1525;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1864574049
   )
   static int field1527;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1756853723
   )
   static int field1528;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-50"
   )
   int method1785(int var1) {
      return this.field1522[var1];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-525390196"
   )
   void method1786(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field1521[var1]) {
         this.field1524 = true;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "596212953"
   )
   String method1787(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "279173012"
   )
   void method1788() {
      int var1;
      for(var1 = 0; var1 < this.field1522.length; ++var1) {
         if(!this.field1519[var1]) {
            this.field1522[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field1521[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1771862309"
   )
   void method1790() {
      FileOnDisk var1 = this.method1791(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field1522.length; ++var4) {
            if(this.field1519[var4] && this.field1522[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field1521[var5] && this.messages[var5] != null) {
               var2 += class5.method11(this.messages[var5]) + 2;
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.field1522.length; ++var6) {
            if(this.field1519[var6] && this.field1522[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.field1522[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field1521[var6] && this.messages[var6] != null) {
               var9.putShort(var6);
               var9.method3150(this.messages[var6]);
            }
         }

         var1.method2364(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method2348();
         } catch (Exception var16) {
            ;
         }

      }

      this.field1524 = false;
      this.field1525 = XGrandExchangeOffer.method96();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "1485197826"
   )
   FileOnDisk method1791(boolean var1) {
      return class151.getPreferencesFile("2", class27.field400.field3192, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1643628721"
   )
   void method1792() {
      if(this.field1524 && this.field1525 < XGrandExchangeOffer.method96() - 60000L) {
         this.method1790();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1144369665"
   )
   void method1796() {
      FileOnDisk var1 = this.method1791(false);

      label193: {
         try {
            byte[] var2 = new byte[(int)var1.method2344()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method2343(var2, var3, var2.length - var3);
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
                  if(this.field1519[var8]) {
                     this.field1522[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label193;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.field1521[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label193;
         } finally {
            try {
               var1.method2348();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field1524 = false;
   }

   ChatMessages() {
      this.field1524 = false;
      this.field1522 = new int[Overlay.field3594.method4187(19)];
      this.messages = new String[Overlay.field3594.method4187(15)];
      this.field1519 = new boolean[this.field1522.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field1522.length; ++var1) {
         class243 var3 = (class243)class243.field3312.get((long)var1);
         class243 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            var4 = class243.field3316.getConfigData(19, var1);
            var3 = new class243();
            if(var4 != null) {
               var3.method4316(new Buffer(var4));
            }

            class243.field3312.put(var3, (long)var1);
            var2 = var3;
         }

         this.field1519[var1] = var2.field3314;
      }

      this.field1521 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class244 var6 = (class244)class244.field3320.get((long)var1);
         class244 var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            var4 = class244.field3319.getConfigData(15, var1);
            var6 = new class244();
            if(var4 != null) {
               var6.method4330(new Buffer(var4));
            }

            class244.field3320.put(var6, (long)var1);
            var5 = var6;
         }

         this.field1521[var1] = var5.field3318;
      }

      for(var1 = 0; var1 < this.field1522.length; ++var1) {
         this.field1522[var1] = -1;
      }

      this.method1796();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1694032316"
   )
   boolean method1808() {
      return this.field1524;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1368699260"
   )
   void method1811(int var1, int var2) {
      this.field1522[var1] = var2;
      if(this.field1519[var1]) {
         this.field1524 = true;
      }

   }
}
