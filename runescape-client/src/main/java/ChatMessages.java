import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("a")
   boolean[] field1536;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 7557978941889218979L
   )
   long field1537;
   @ObfuscatedName("s")
   int[] field1538;
   @ObfuscatedName("r")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("v")
   boolean field1540;
   @ObfuscatedName("t")
   boolean[] field1541;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1899521483"
   )
   void method1803(int var1, int var2) {
      this.field1538[var1] = var2;
      if(this.field1536[var1]) {
         this.field1540 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-746461368"
   )
   int method1804(int var1) {
      return this.field1538[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1990367315"
   )
   void method1805(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field1541[var1]) {
         this.field1540 = true;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1335115471"
   )
   String method1806(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1875973342"
   )
   void method1807() {
      FileOnDisk var1 = this.method1808(false);

      label188: {
         try {
            byte[] var2 = new byte[(int)var1.method2379()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method2367(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset >= 1) {
               int var5 = var13.readUnsignedByte();
               if(var5 < 0 || var5 > 1) {
                  return;
               }

               int var6 = var13.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var13.readUnsignedShort();
                  var9 = var13.readInt();
                  if(this.field1536[var8]) {
                     this.field1538[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label188;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.field1541[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label188;
         } finally {
            try {
               var1.method2381();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field1540 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-1809469181"
   )
   FileOnDisk method1808(boolean var1) {
      return class22.getPreferencesFile("2", Client.field1207.field3203, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   void method1809() {
      FileOnDisk var1 = this.method1808(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field1538.length; ++var4) {
            if(this.field1536[var4] && this.field1538[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field1541[var5] && this.messages[var5] != null) {
               var2 += 2 + class261.method4734(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.field1538.length; ++var6) {
            if(this.field1536[var6] && this.field1538[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.field1538[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field1541[var6] && this.messages[var6] != null) {
               var9.putShort(var6);
               var9.method3137(this.messages[var6]);
            }
         }

         var1.method2363(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method2381();
         } catch (Exception var16) {
            ;
         }

      }

      this.field1540 = false;
      this.field1537 = class172.method3128();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
   )
   void method1810() {
      int var1;
      for(var1 = 0; var1 < this.field1538.length; ++var1) {
         if(!this.field1536[var1]) {
            this.field1538[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field1541[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-650121609"
   )
   boolean method1811() {
      return this.field1540;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "95"
   )
   void method1833() {
      if(this.field1540 && this.field1537 < class172.method3128() - 60000L) {
         this.method1809();
      }

   }

   ChatMessages() {
      this.field1540 = false;
      this.field1538 = new int[class91.field1446.method4133(19)];
      this.messages = new String[class91.field1446.method4133(15)];
      this.field1536 = new boolean[this.field1538.length];

      int var1;
      for(var1 = 0; var1 < this.field1538.length; ++var1) {
         class243 var3 = (class243)class243.field3317.get((long)var1);
         class243 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class243.field3319.getConfigData(19, var1);
            var3 = new class243();
            if(var4 != null) {
               var3.method4315(new Buffer(var4));
            }

            class243.field3317.put(var3, (long)var1);
            var2 = var3;
         }

         this.field1536[var1] = var2.field3318;
      }

      this.field1541 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class244 var5 = class205.method3803(var1);
         this.field1541[var1] = var5.field3323;
      }

      for(var1 = 0; var1 < this.field1538.length; ++var1) {
         this.field1538[var1] = -1;
      }

      this.method1807();
   }
}
