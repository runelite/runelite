import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -6607805768611239109L
   )
   long field266;
   @ObfuscatedName("n")
   boolean[] field267;
   @ObfuscatedName("v")
   int[] field269;
   @ObfuscatedName("b")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("m")
   boolean field271 = false;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 971092781
   )
   static int field272;
   @ObfuscatedName("t")
   boolean[] field273;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -1988603627
   )
   static int field274;
   @ObfuscatedName("ao")
   static boolean field276;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method196(int var1, int var2) {
      this.field269[var1] = var2;
      if(this.field267[var1]) {
         this.field271 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1390137108"
   )
   int method197(int var1) {
      return this.field269[var1];
   }

   ChatMessages() {
      this.field269 = new int[Client.field312.method3321(19)];
      this.messages = new String[Client.field312.method3321(15)];
      this.field267 = new boolean[this.field269.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field269.length; ++var1) {
         class47 var3 = (class47)class47.field1046.get((long)var1);
         class47 var2;
         if(null != var3) {
            var2 = var3;
         } else {
            var4 = class47.field1047.method3304(19, var1);
            var3 = new class47();
            if(null != var4) {
               var3.method961(new Buffer(var4));
            }

            class47.field1046.put(var3, (long)var1);
            var2 = var3;
         }

         this.field267[var1] = var2.field1051;
      }

      this.field273 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class53 var6 = (class53)class53.field1137.get((long)var1);
         class53 var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            var4 = class53.field1138.method3304(15, var1);
            var6 = new class53();
            if(var4 != null) {
               var6.method1082(new Buffer(var4));
            }

            class53.field1137.put(var6, (long)var1);
            var5 = var6;
         }

         this.field273[var1] = var5.field1139;
      }

      for(var1 = 0; var1 < this.field269.length; ++var1) {
         this.field269[var1] = -1;
      }

      this.method210();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "17"
   )
   void method199() {
      int var1;
      for(var1 = 0; var1 < this.field269.length; ++var1) {
         if(!this.field267[var1]) {
            this.field269[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field273[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZB)LFileOnDisk;",
      garbageValue = "79"
   )
   FileOnDisk method200(boolean var1) {
      return Actor.method786("2", class164.field2676.field2332, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "6858"
   )
   void method201() {
      FileOnDisk var1 = this.method200(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field269.length; ++var4) {
            if(this.field267[var4] && this.field269[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field273[var5] && this.messages[var5] != null) {
               var2 += 2 + class75.method1624(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2518(1);
         var9.method2519(var3);

         int var6;
         for(var6 = 0; var6 < this.field269.length; ++var6) {
            if(this.field267[var6] && this.field269[var6] != -1) {
               var9.method2519(var6);
               var9.method2521(this.field269[var6]);
            }
         }

         var9.method2519(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field273[var6] && this.messages[var6] != null) {
               var9.method2519(var6);
               var9.method2524(this.messages[var6]);
            }
         }

         var1.method4190(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4191();
         } catch (Exception var16) {
            ;
         }

      }

      this.field271 = false;
      this.field266 = class11.method139();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1992785444"
   )
   void method202(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field273[var1]) {
         this.field271 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2092522183"
   )
   void method203() {
      if(this.field271 && this.field266 < class11.method139() - 60000L) {
         this.method201();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1712937323"
   )
   boolean method204() {
      return this.field271;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3009"
   )
   void method210() {
      FileOnDisk var1 = this.method200(false);

      label197: {
         try {
            byte[] var2 = new byte[(int)var1.method4206()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4193(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.method2656();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method2535();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2535();
                  var9 = var13.method2538();
                  if(this.field267[var8]) {
                     this.field269[var8] = var9;
                  }
               }

               var7 = var13.method2535();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label197;
                  }

                  var9 = var13.method2535();
                  String var10 = var13.method2541();
                  if(this.field273[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label197;
         } finally {
            try {
               var1.method4191();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field271 = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "50"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method636() != Client.isMembers) {
         Client.isMembers = var0.method636();
         boolean var1 = var0.method636();
         if(var1 != ItemComposition.isMembersWorld) {
            class119.method2479();
            ItemComposition.isMembersWorld = var1;
         }
      }

      World.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class28.field673 = Client.field343 == 0?'ꩊ':'鱀' + var0.id;
      class35.field781 = Client.field343 == 0?443:var0.id + '썐';
      class114.field2013 = class28.field673;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1645233628"
   )
   String method225(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "671712175"
   )
   public static boolean method231(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
