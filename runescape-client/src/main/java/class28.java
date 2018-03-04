import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public abstract class class28 {
   @ObfuscatedName("ar")
   protected static String field425;
   @ObfuscatedName("ab")
   protected static GarbageCollectorMXBean field421;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1378022435
   )
   static int field412;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1659787295
   )
   int field411;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2101310959
   )
   int field420;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 561280267
   )
   int field422;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -674688019
   )
   int field413;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2128157255
   )
   int field414;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1273666573
   )
   int field410;
   @ObfuscatedName("k")
   short[][][] field423;
   @ObfuscatedName("s")
   short[][][] field416;
   @ObfuscatedName("p")
   byte[][][] field418;
   @ObfuscatedName("x")
   byte[][][] field419;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[[[Lau;"
   )
   class31[][][][] field417;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILgy;B)V",
      garbageValue = "0"
   )
   void method225(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method243(var1, var2, var3, var4);
         } else {
            this.method228(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILgy;II)V",
      garbageValue = "-796729203"
   )
   void method243(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field416[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field423[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILgy;II)V",
      garbageValue = "455738464"
   )
   void method228(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field423[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field416[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field418[var9][var1][var2] = (byte)(var11 >> 2);
               this.field419[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field417[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3617();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "144814518"
   )
   int method229(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field423[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1643565014"
   )
   int method230() {
      return this.field422;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-86"
   )
   int method231() {
      return this.field413;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1336448478"
   )
   static long method237() {
      try {
         URL var0 = new URL(class281.method5109("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-27"
   )
   public static int method226(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-2044326229"
   )
   static int method236(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class81.intStackSize -= 2;
         Client.field871 = (short)class81.intStack[class81.intStackSize];
         if(Client.field871 <= 0) {
            Client.field871 = 256;
         }

         Client.field1099 = (short)class81.intStack[class81.intStackSize + 1];
         if(Client.field1099 <= 0) {
            Client.field1099 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class81.intStackSize -= 2;
         Client.field1100 = (short)class81.intStack[class81.intStackSize];
         if(Client.field1100 <= 0) {
            Client.field1100 = 256;
         }

         Client.field1101 = (short)class81.intStack[class81.intStackSize + 1];
         if(Client.field1101 <= 0) {
            Client.field1101 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class81.intStackSize -= 4;
         Client.field893 = (short)class81.intStack[class81.intStackSize];
         if(Client.field893 <= 0) {
            Client.field893 = 1;
         }

         Client.field860 = (short)class81.intStack[class81.intStackSize + 1];
         if(Client.field860 <= 0) {
            Client.field860 = 32767;
         } else if(Client.field860 < Client.field893) {
            Client.field860 = Client.field893;
         }

         Client.field1104 = (short)class81.intStack[class81.intStackSize + 2];
         if(Client.field1104 <= 0) {
            Client.field1104 = 1;
         }

         Client.field992 = (short)class81.intStack[class81.intStackSize + 3];
         if(Client.field992 <= 0) {
            Client.field992 = 32767;
         } else if(Client.field992 < Client.field1104) {
            Client.field992 = Client.field1104;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1020 != null) {
            GameSocket.method3420(0, 0, Client.field1020.width, Client.field1020.height, false);
            class81.intStack[++class81.intStackSize - 1] = Client.viewportWidth;
            class81.intStack[++class81.intStackSize - 1] = Client.viewportHeight;
         } else {
            class81.intStack[++class81.intStackSize - 1] = -1;
            class81.intStack[++class81.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class81.intStack[++class81.intStackSize - 1] = Client.field1100;
         class81.intStack[++class81.intStackSize - 1] = Client.field1101;
         return 1;
      } else if(var0 == 6205) {
         class81.intStack[++class81.intStackSize - 1] = Client.field871;
         class81.intStack[++class81.intStackSize - 1] = Client.field1099;
         return 1;
      } else {
         return 2;
      }
   }
}
