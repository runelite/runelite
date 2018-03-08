import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field1417;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1021424151
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("i")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("a")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("l")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("b")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("e")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -8045112579915343631L
   )
   long field1414;

   Varcs() {
      this.changed = false;
      this.varcs = new int[Client.configsIndex.fileCount(19)];
      this.varcstrings = new String[Client.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class270 var3 = (class270)class270.field3478.get((long)var1);
         class270 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            var4 = class270.field3480.getConfigData(19, var1);
            var3 = new class270();
            if(var4 != null) {
               var3.method4790(new Buffer(var4));
            }

            class270.field3478.put(var3, (long)var1);
            var2 = var3;
         }

         this.varcSerials[var1] = var2.field3477;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class271 var6 = (class271)class271.field3482.get((long)var1);
         class271 var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            var4 = class271.field3485.getConfigData(15, var1);
            var6 = new class271();
            if(var4 != null) {
               var6.method4797(new Buffer(var4));
            }

            class271.field3482.put(var6, (long)var1);
            var5 = var6;
         }

         this.varcstringSerials[var1] = var5.field3484;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-66"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1587184079"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "126254292"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1834064626"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1168462187"
   )
   @Export("reset")
   void reset() {
      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         if(!this.varcSerials[var1]) {
            this.varcs[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         if(!this.varcstringSerials[var1]) {
            this.varcstrings[var1] = null;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)Lde;",
      garbageValue = "1181309640"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return class297.getPreferencesFile("2", Client.field852.name, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1542057536"
   )
   @Export("serialize")
   void serialize() {
      FileOnDisk var1 = this.getVarPrefs(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.varcs.length; ++var4) {
            if(this.varcSerials[var4] && this.varcs[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.varcstrings.length; ++var5) {
            if(this.varcstringSerials[var5] && this.varcstrings[var5] != null) {
               var2 += 2 + UnitPriceComparator.getLength(this.varcstrings[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.varcs.length; ++var6) {
            if(this.varcSerials[var6] && this.varcs[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.varcs[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.varcstrings.length; ++var6) {
            if(this.varcstringSerials[var6] && this.varcstrings[var6] != null) {
               var9.putShort(var6);
               var9.putString(this.varcstrings[var6]);
            }
         }

         var1.write(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var16) {
            ;
         }

      }

      this.changed = false;
      this.field1414 = WorldMapRegion.method465();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2031916597"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label205: {
         try {
            byte[] var2 = new byte[(int)var1.length()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.read(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset >= 1) {
               int var14 = var13.readUnsignedByte();
               if(var14 >= 0 && var14 <= 1) {
                  int var15 = var13.readUnsignedShort();

                  int var7;
                  int var8;
                  int var9;
                  for(var7 = 0; var7 < var15; ++var7) {
                     var8 = var13.readUnsignedShort();
                     var9 = var13.readInt();
                     if(this.varcSerials[var8]) {
                        this.varcs[var8] = var9;
                     }
                  }

                  var7 = var13.readUnsignedShort();
                  var8 = 0;

                  while(true) {
                     if(var8 >= var7) {
                        break label205;
                     }

                     var9 = var13.readUnsignedShort();
                     String var10 = var13.readString();
                     if(this.varcstringSerials[var9]) {
                        this.varcstrings[var9] = var10;
                     }

                     ++var8;
                  }
               }

               return;
            }
         } catch (Exception var24) {
            break label205;
         } finally {
            try {
               var1.close();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.changed = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   @Export("process")
   void process() {
      if(this.changed && this.field1414 < WorldMapRegion.method465() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "491075725"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static final void method2004() {
      PacketNode var0 = class33.method382(ClientPacket.field2428, Client.field1072.field1456);
      var0.packetBuffer.putByte(0);
      Client.field1072.method2073(var0);
   }
}
