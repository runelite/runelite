import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("y")
   static Buffer field905;
   @ObfuscatedName("i")
   boolean[] field907;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 8388379899530233827L
   )
   long field908;
   @ObfuscatedName("a")
   boolean[] field909;
   @ObfuscatedName("c")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("d")
   boolean field911 = false;
   @ObfuscatedName("m")
   public static class144 field914;
   @ObfuscatedName("f")
   int[] field915;
   @ObfuscatedName("t")
   public static boolean field916;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1793134309"
   )
   void method821(int var1, int var2) {
      this.field915[var1] = var2;
      if(this.field907[var1]) {
         this.field911 = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "85"
   )
   int method822(int var1) {
      return this.field915[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "2"
   )
   void method823(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field909[var1]) {
         this.field911 = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2000603419"
   )
   String method824(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   public static void method826() {
      try {
         class104.field1676.method1334();

         for(int var0 = 0; var0 < class104.field1673; ++var0) {
            class215.field3160[var0].method1334();
         }

         class104.field1677.method1334();
         class104.field1682.method1334();
      } catch (Exception var1) {
         ;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1610838303"
   )
   void method828() {
      FileOnDisk var1 = this.method841(false);

      label196: {
         try {
            byte[] var2 = new byte[(int)var1.method1367()];

            int var3;
            for(int var4 = 0; var4 < var2.length; var4 += var3) {
               var3 = var1.method1368(var2, var4, var2.length - var4);
               if(var3 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var23 = new Buffer(var2);
            if(var23.payload.length - var23.offset >= 1) {
               int var5 = var23.readUnsignedByte();
               if(var5 >= 0 && var5 <= 1) {
                  int var6 = var23.readUnsignedShort();

                  int var7;
                  int var8;
                  int var9;
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = var23.readUnsignedShort();
                     var9 = var23.method2780();
                     if(this.field907[var8]) {
                        this.field915[var8] = var9;
                     }
                  }

                  var7 = var23.readUnsignedShort();
                  var8 = 0;

                  while(true) {
                     if(var8 >= var7) {
                        break label196;
                     }

                     var9 = var23.readUnsignedShort();
                     String var10 = var23.method2965();
                     if(this.field909[var9]) {
                        this.messages[var9] = var10;
                     }

                     ++var8;
                  }
               }

               return;
            }
         } catch (Exception var21) {
            break label196;
         } finally {
            try {
               var1.method1365();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field911 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-100"
   )
   void method829() {
      if(this.field911 && this.field908 < class9.method117() - 60000L) {
         this.method842();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1799567465"
   )
   void method830() {
      int var1;
      for(var1 = 0; var1 < this.field915.length; ++var1) {
         if(!this.field907[var1]) {
            this.field915[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field909[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1806553804"
   )
   boolean method838() {
      return this.field911;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZS)LFileOnDisk;",
      garbageValue = "10492"
   )
   FileOnDisk method841(boolean var1) {
      return class47.method856("2", class13.field139.field2669, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1786857704"
   )
   void method842() {
      FileOnDisk var1 = this.method841(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field915.length; ++var4) {
            if(this.field907[var4] && this.field915[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field909[var5] && this.messages[var5] != null) {
               var2 += 2 + class148.method2740(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var17 = new Buffer(var2);
         var17.method2760(1);
         var17.method2918(var3);

         int var6;
         for(var6 = 0; var6 < this.field915.length; ++var6) {
            if(this.field907[var6] && this.field915[var6] != -1) {
               var17.method2918(var6);
               var17.method2763(this.field915[var6]);
            }
         }

         var17.method2918(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field909[var6] && null != this.messages[var6]) {
               var17.method2918(var6);
               var17.method2811(this.messages[var6]);
            }
         }

         var1.method1375(var17.payload, 0, var17.offset);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method1365();
         } catch (Exception var14) {
            ;
         }

      }

      this.field911 = false;
      this.field908 = class9.method117();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-43"
   )
   static SpritePixels method850() {
      SpritePixels var0 = new SpritePixels();
      var0.field3205 = class225.field3214;
      var0.field3207 = class202.field3060;
      var0.field3209 = class225.field3213[0];
      var0.field3208 = class225.field3216[0];
      var0.width = class225.field3217[0];
      var0.height = class178.field2653[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class119.field1845[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class225.field3218[var2[var3] & 255];
      }

      class225.field3213 = null;
      class225.field3216 = null;
      class225.field3217 = null;
      class178.field2653 = null;
      class225.field3218 = null;
      class119.field1845 = (byte[][])null;
      return var0;
   }

   ChatMessages() {
      this.field915 = new int[class48.field936.method3323(19)];
      this.messages = new String[class48.field936.method3323(15)];
      this.field907 = new boolean[this.field915.length];

      int var1;
      for(var1 = 0; var1 < this.field915.length; ++var1) {
         class188 var2 = (class188)class188.field2754.get((long)var1);
         class188 var3;
         if(null != var2) {
            var3 = var2;
         } else {
            byte[] var4 = class188.field2753.method3272(19, var1);
            var2 = new class188();
            if(var4 != null) {
               var2.method3430(new Buffer(var4));
            }

            class188.field2754.put(var2, (long)var1);
            var3 = var2;
         }

         this.field907[var1] = var3.field2755;
      }

      this.field909 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var5 = class1.method16(var1);
         this.field909[var1] = var5.field2761;
      }

      for(var1 = 0; var1 < this.field915.length; ++var1) {
         this.field915[var1] = -1;
      }

      this.method828();
   }
}
