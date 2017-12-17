import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("w")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -2086350283936535427L
   )
   long field1657;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1358459689
   )
   int field1649;
   @ObfuscatedName("u")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8147357022237717303L
   )
   long field1651;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 574183265
   )
   int field1652;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 1092840870758656945L
   )
   @Export("position")
   long position;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 32181713884337277L
   )
   @Export("length")
   long length;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -1754338581505271593L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -4816907015001781409L
   )
   long field1647;

   @ObfuscatedSignature(
      signature = "(Lda;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1657 = -1L;
      this.field1651 = -1L;
      this.field1652 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1921781252"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("w")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "777235063"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2039742006"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-94"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1651 && this.position >= this.field1651 && this.position + (long)var3 <= (long)this.field1652 + this.field1651) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1651), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1657 && this.position < this.field1657 + (long)this.field1649) {
            var8 = (int)((long)this.field1649 - (this.position - this.field1657));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1657), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1647 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1647 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1649) {
               var8 = this.field1649;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1651 != -1L) {
            if(this.field1651 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1651 - this.position);
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
            if(this.field1651 >= var4 && this.field1651 < var4 + (long)var7) {
               var13 = this.field1651;
            } else if(var4 >= this.field1651 && var4 < (long)this.field1652 + this.field1651) {
               var13 = var4;
            }

            if((long)this.field1652 + this.field1651 > var4 && (long)this.field1652 + this.field1651 <= (long)var7 + var4) {
               var10 = this.field1651 + (long)this.field1652;
            } else if(var4 + (long)var7 > this.field1651 && (long)var7 + var4 <= (long)this.field1652 + this.field1651) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1651), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1647 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-28050"
   )
   @Export("load")
   void load() throws IOException {
      this.field1649 = 0;
      if(this.field1647 != this.position) {
         this.accessFile.seek(this.position);
         this.field1647 = this.position;
      }

      int var1;
      for(this.field1657 = this.position; this.field1649 < this.readPayload.length; this.field1649 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1649, this.readPayload.length - this.field1649);
         if(var1 == -1) {
            break;
         }

         this.field1647 += (long)var1;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "3"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.capacity) {
            this.capacity = this.position + (long)var3;
         }

         if(this.field1651 != -1L && (this.position < this.field1651 || this.position > this.field1651 + (long)this.field1652)) {
            this.flush();
         }

         if(this.field1651 != -1L && (long)var3 + this.position > this.field1651 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1651));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1651), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1652 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1651 == -1L) {
                  this.field1651 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1651), var3);
               this.position += (long)var3;
               if(this.position - this.field1651 > (long)this.field1652) {
                  this.field1652 = (int)(this.position - this.field1651);
               }

            }
         } else {
            if(this.position != this.field1647) {
               this.accessFile.seek(this.position);
               this.field1647 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1647 += (long)var3;
            if(this.field1647 > this.length) {
               this.length = this.field1647;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1657 && this.position < (long)this.field1649 + this.field1657) {
               var9 = this.position;
            } else if(this.field1657 >= this.position && this.field1657 < this.position + (long)var3) {
               var9 = this.field1657;
            }

            if(this.position + (long)var3 > this.field1657 && (long)var3 + this.position <= this.field1657 + (long)this.field1649) {
               var6 = this.position + (long)var3;
            } else if(this.field1657 + (long)this.field1649 > this.position && this.field1657 + (long)this.field1649 <= this.position + (long)var3) {
               var6 = this.field1657 + (long)this.field1649;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1657), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1647 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1440292873"
   )
   @Export("flush")
   void flush() throws IOException {
      if(-1L != this.field1651) {
         if(this.field1647 != this.field1651) {
            this.accessFile.seek(this.field1651);
            this.field1647 = this.field1651;
         }

         this.accessFile.write(this.writePayload, 0, this.field1652);
         this.field1647 += 574183265L * (long)(this.field1652 * 1250397345);
         if(this.field1647 > this.length) {
            this.length = this.field1647;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1651 >= this.field1657 && this.field1651 < this.field1657 + (long)this.field1649) {
            var1 = this.field1651;
         } else if(this.field1657 >= this.field1651 && this.field1657 < (long)this.field1652 + this.field1651) {
            var1 = this.field1657;
         }

         if(this.field1651 + (long)this.field1652 > this.field1657 && this.field1651 + (long)this.field1652 <= this.field1657 + (long)this.field1649) {
            var3 = (long)this.field1652 + this.field1651;
         } else if((long)this.field1649 + this.field1657 > this.field1651 && this.field1657 + (long)this.field1649 <= this.field1651 + (long)this.field1652) {
            var3 = this.field1657 + (long)this.field1649;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1651), this.readPayload, (int)(var1 - this.field1657), var5);
         }

         this.field1651 = -1L;
         this.field1652 = 0;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lby;S)V",
      garbageValue = "7680"
   )
   public static void method2350(ScriptEvent var0) {
      class21.method153(var0, 200000);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljf;",
      garbageValue = "79"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.boolean1 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "72350917"
   )
   @Export("decodeSprite")
   public static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class299.field3866 = var1.readUnsignedShort();
      class299.field3867 = new int[class299.field3866];
      class299.offsetsY = new int[class299.field3866];
      Item.field1387 = new int[class299.field3866];
      class276.field3727 = new int[class299.field3866];
      Bounds.spritePixels = new byte[class299.field3866][];
      var1.offset = var0.length - 7 - class299.field3866 * 8;
      class299.field3864 = var1.readUnsignedShort();
      class299.field3868 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class299.field3866; ++var3) {
         class299.field3867[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class299.field3866; ++var3) {
         class299.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class299.field3866; ++var3) {
         Item.field1387[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class299.field3866; ++var3) {
         class276.field3727[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class299.field3866 * 8 - (var2 - 1) * 3;
      FaceNormal.field2025 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         FaceNormal.field2025[var3] = var1.read24BitInt();
         if(FaceNormal.field2025[var3] == 0) {
            FaceNormal.field2025[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class299.field3866; ++var3) {
         int var4 = Item.field1387[var3];
         int var5 = class276.field3727[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         Bounds.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-886108218"
   )
   static int method2352(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         int[] var3 = class82.intStack;
         int var4 = ++class82.intStackSize - 1;
         int var5 = Client.isResized?2:1;
         var3[var4] = var5;
         return 1;
      } else {
         int var6;
         if(var0 == 5307) {
            var6 = class82.intStack[--class82.intStackSize];
            if(var6 == 1 || var6 == 2) {
               class35.method494(var6);
            }

            return 1;
         } else if(var0 == 5308) {
            class82.intStack[++class82.intStackSize - 1] = class2.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var6 = class82.intStack[--class82.intStackSize];
            if(var6 == 1 || var6 == 2) {
               class2.preferences.screenType = var6;
               WorldComparator.method63();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Lhz;I)Lhz;",
      garbageValue = "145236519"
   )
   static Widget method2351(Widget var0) {
      Widget var2 = var0;
      int var3 = Widget.method4188(class36.getWidgetConfig(var0));
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               var1 = var2;
               break;
            }

            var2 = VertexNormal.getWidget(var2.parentId);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var4;
         }
      }

      Widget var5 = var1;
      if(var1 == null) {
         var5 = var0.dragParent;
      }

      return var5;
   }
}
