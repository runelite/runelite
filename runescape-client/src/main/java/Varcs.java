import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("ne")
   @ObfuscatedSignature(
      signature = "[Lbg;"
   )
   @Export("clanMembers")
   static ClanMember[] clanMembers;
   @ObfuscatedName("dh")
   @Export("host")
   static String host;
   @ObfuscatedName("r")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("g")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("x")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("f")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("u")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 5995212031901623627L
   )
   @Export("lastSerialize")
   long lastSerialize;

   Varcs() {
      this.changed = false;
      this.varcs = new int[class229.configsIndex.fileCount(19)];
      this.varcstrings = new String[class229.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class250 var2 = class66.method1022(var1);
         this.varcSerials[var1] = var2.field3368;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class251 var3 = (class251)class251.field3371.get((long)var1);
         class251 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class251.field3372.getConfigData(15, var1);
            var3 = new class251();
            if(var4 != null) {
               var3.method4315(new Buffer(var4));
            }

            class251.field3371.put(var3, (long)var1);
            var5 = var3;
         }

         this.varcstringSerials[var1] = var5.field3370;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "125"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-41"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "2043342364"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "987902497"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-981175803"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZB)Ldx;",
      garbageValue = "-50"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return GroundObject.getPreferencesFile("2", FileSystem.field3262.field3256, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1516772897"
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
               var2 += 2 + class23.getLength(this.varcstrings[var5]);
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
      this.lastSerialize = ChatLineBuffer.currentTimeMs();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "496250057"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label186: {
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
                  if(this.varcSerials[var8]) {
                     this.varcs[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label186;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.varcstringSerials[var9]) {
                     this.varcstrings[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label186;
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-120"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < ChatLineBuffer.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2070172540"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lfc;",
      garbageValue = "1866631786"
   )
   public static PacketNode method1804() {
      return PacketNode.field2420 == 0?new PacketNode():PacketNode.field2419[--PacketNode.field2420];
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "2137513630"
   )
   static final void method1803(Widget var0, int var1, int var2) {
      if(Client.field1108 == 0 || Client.field1108 == 3) {
         if(MouseInput.field687 == 1 || !Signlink.field2142 && MouseInput.field687 == 4) {
            class217 var3 = var0.method4027(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.field674 - var1;
            int var5 = MouseInput.field688 - var2;
            if(var3.method3961(var4, var5)) {
               var4 -= var3.field2673 / 2;
               var5 -= var3.field2672 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var4 * var8 + var5 * var7 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + class275.localPlayer.x >> 7;
               int var12 = class275.localPlayer.y - var10 >> 7;
               PacketNode var13 = class18.method133(ClientPacket.field2358, Client.field905.field1460);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.method3219(var11 + class13.baseX);
               var13.packetBuffer.method3210(KeyFocusListener.field578[82]?(KeyFocusListener.field578[81]?2:1):0);
               var13.packetBuffer.putShortLE(var12 + ClanMember.baseY);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(class275.localPlayer.x);
               var13.packetBuffer.putShort(class275.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field905.method1855(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "779491786"
   )
   static void method1805() {
      class34.method458(class275.localPlayer, false);
   }
}
