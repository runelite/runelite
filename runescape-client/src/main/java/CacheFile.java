import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   FileOnDisk field1675;
   @ObfuscatedName("x")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -3568174410201910447L
   )
   long field1680;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 434187121
   )
   int field1670;
   @ObfuscatedName("v")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -3402261524389564359L
   )
   long field1672;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1774963635
   )
   int field1676;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 5030143846993206461L
   )
   @Export("position")
   long position;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 5520648876968811803L
   )
   @Export("length")
   long length;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 2380844932756416615L
   )
   long field1673;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 6353558333146110219L
   )
   long field1677;

   @ObfuscatedSignature(
      signature = "(Ldt;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1680 = -1L;
      this.field1672 = -1L;
      this.field1676 = 0;
      this.field1675 = var1;
      this.field1673 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   public void method2427() throws IOException {
      this.method2434();
      this.field1675.close();
   }

   @ObfuscatedName("x")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "36"
   )
   public long method2429() {
      return this.field1673;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "114"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2431(var1, 0, var1.length);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "640955248"
   )
   public void method2431(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1672 != -1L && this.position >= this.field1672 && this.position + (long)var3 <= (long)this.field1676 + this.field1672) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1672), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1680 && this.position < this.field1680 + (long)this.field1670) {
            var8 = (int)((long)this.field1670 - (this.position - this.field1680));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1680), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1675.seek(this.position);

            for(this.field1677 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1675.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1677 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2432();
            var8 = var3;
            if(var3 > this.field1670) {
               var8 = this.field1670;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1672 != -1L) {
            if(this.field1672 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1672 - this.position);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.position;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1672 >= var4 && this.field1672 < var4 + (long)var7) {
               var13 = this.field1672;
            } else if(var4 >= this.field1672 && var4 < (long)this.field1676 + this.field1672) {
               var13 = var4;
            }

            if(this.field1672 + (long)this.field1676 > var4 && this.field1672 + (long)this.field1676 <= (long)var7 + var4) {
               var10 = (long)this.field1676 + this.field1672;
            } else if(var4 + (long)var7 > this.field1672 && var4 + (long)var7 <= (long)this.field1676 + this.field1672) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1672), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1677 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-421926192"
   )
   void method2432() throws IOException {
      this.field1670 = 0;
      if(this.position != this.field1677) {
         this.field1675.seek(this.position);
         this.field1677 = this.position;
      }

      int var1;
      for(this.field1680 = this.position; this.field1670 < this.readPayload.length; this.field1670 += var1) {
         var1 = this.field1675.read(this.readPayload, this.field1670, this.readPayload.length - this.field1670);
         if(var1 == -1) {
            break;
         }

         this.field1677 += (long)var1;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1441769987"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1673) {
            this.field1673 = this.position + (long)var3;
         }

         if(-1L != this.field1672 && (this.position < this.field1672 || this.position > (long)this.field1676 + this.field1672)) {
            this.method2434();
         }

         if(-1L != this.field1672 && this.position + (long)var3 > (long)this.writePayload.length + this.field1672) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1672));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1672), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1676 = this.writePayload.length;
            this.method2434();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1672 == -1L) {
                  this.field1672 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1672), var3);
               this.position += (long)var3;
               if(this.position - this.field1672 > (long)this.field1676) {
                  this.field1676 = (int)(this.position - this.field1672);
               }

            }
         } else {
            if(this.position != this.field1677) {
               this.field1675.seek(this.position);
               this.field1677 = this.position;
            }

            this.field1675.write(var1, var2, var3);
            this.field1677 += (long)var3;
            if(this.field1677 > this.length) {
               this.length = this.field1677;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1680 && this.position < this.field1680 + (long)this.field1670) {
               var9 = this.position;
            } else if(this.field1680 >= this.position && this.field1680 < this.position + (long)var3) {
               var9 = this.field1680;
            }

            if((long)var3 + this.position > this.field1680 && this.position + (long)var3 <= this.field1680 + (long)this.field1670) {
               var6 = this.position + (long)var3;
            } else if(this.field1680 + (long)this.field1670 > this.position && this.field1680 + (long)this.field1670 <= this.position + (long)var3) {
               var6 = (long)this.field1670 + this.field1680;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1680), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1677 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-662000482"
   )
   void method2434() throws IOException {
      if(-1L != this.field1672) {
         if(this.field1677 != this.field1672) {
            this.field1675.seek(this.field1672);
            this.field1677 = this.field1672;
         }

         this.field1675.write(this.writePayload, 0, this.field1676);
         this.field1677 += 1774963635L * (long)(this.field1676 * 1197595515);
         if(this.field1677 > this.length) {
            this.length = this.field1677;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1672 >= this.field1680 && this.field1672 < this.field1680 + (long)this.field1670) {
            var1 = this.field1672;
         } else if(this.field1680 >= this.field1672 && this.field1680 < (long)this.field1676 + this.field1672) {
            var1 = this.field1680;
         }

         if((long)this.field1676 + this.field1672 > this.field1680 && this.field1672 + (long)this.field1676 <= this.field1680 + (long)this.field1670) {
            var3 = this.field1672 + (long)this.field1676;
         } else if(this.field1680 + (long)this.field1670 > this.field1672 && (long)this.field1670 + this.field1680 <= this.field1672 + (long)this.field1676) {
            var3 = (long)this.field1670 + this.field1680;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1672), this.readPayload, (int)(var1 - this.field1680), var5);
         }

         this.field1672 = -1L;
         this.field1676 = 0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;Lgi;B)Lgi;",
      garbageValue = "-43"
   )
   static final IterableHashTable method2453(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class100.method1943(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Liy;",
      garbageValue = "94"
   )
   public static BuildType method2451(int var0) {
      BuildType[] var1 = new BuildType[]{BuildType.BUILD_LIVE, BuildType.RC, BuildType.WIP, BuildType.LIVE};
      BuildType[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         BuildType var4 = var2[var3];
         if(var0 == var4.ordinal) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(Lhx;II)I",
      garbageValue = "1965528537"
   )
   static final int method2441(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class87.method1762(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!WorldMapType2.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class218.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class229.field2912[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class218.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = class181.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class229.field2916[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class87.method1762(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!WorldMapType2.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class218.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = Friend.method1109(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class181.localPlayer.x >> 7) + IndexDataBase.baseX;
               }

               if(var6 == 19) {
                  var7 = (class181.localPlayer.y >> 7) + Occluder.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
