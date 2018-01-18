import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("nq")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   static class289 field580;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("fonts")
   static Fonts fonts;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -250984577
   )
   int field590;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -71928703
   )
   int field586;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 16753899
   )
   int field581;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1056275309
   )
   int field582;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2063329359
   )
   int field583;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1409737139
   )
   int field584;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2068092031
   )
   int field585;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1357597339
   )
   int field587;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -556472273
   )
   int field579;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -743200655
   )
   int field588;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1596430382"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field437 > this.field583) {
         var1.field437 = this.field583;
      }

      if(var1.field434 < this.field583) {
         var1.field434 = this.field583;
      }

      if(var1.field436 > this.field584) {
         var1.field436 = this.field584;
      }

      if(var1.field440 < this.field584) {
         var1.field440 = this.field584;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field590 && var1 < this.field586 + this.field590?var2 >= (this.field581 << 6) + (this.field585 << 3) && var2 <= (this.field581 << 6) + (this.field585 << 3) + 7 && var3 >= (this.field582 << 6) + (this.field587 << 3) && var3 <= (this.field582 << 6) + (this.field587 << 3) + 7:false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-870088204"
   )
   public boolean vmethod697(int var1, int var2) {
      return var1 >= (this.field583 << 6) + (this.field579 << 3) && var1 <= (this.field583 << 6) + (this.field579 << 3) + 7 && var2 >= (this.field584 << 6) + (this.field588 << 3) && var2 <= (this.field584 << 6) + (this.field588 << 3) + 7;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "438384537"
   )
   public int[] vmethod716(int var1, int var2, int var3) {
      if(!this.vmethod696(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field583 * 64 - this.field581 * 64 + var2 + (this.field579 * 8 - this.field585 * 8), var3 + (this.field584 * 64 - this.field582 * 64) + (this.field588 * 8 - this.field587 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Lht;",
      garbageValue = "1662378690"
   )
   public Coordinates vmethod694(int var1, int var2) {
      if(!this.vmethod697(var1, var2)) {
         return null;
      } else {
         int var3 = this.field581 * 64 - this.field583 * 64 + (this.field585 * 8 - this.field579 * 8) + var1;
         int var4 = this.field582 * 64 - this.field584 * 64 + var2 + (this.field587 * 8 - this.field588 * 8);
         return new Coordinates(this.field590, var3, var4);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "1961822977"
   )
   public void vmethod700(Buffer var1) {
      this.field590 = var1.readUnsignedByte();
      this.field586 = var1.readUnsignedByte();
      this.field581 = var1.readUnsignedShort();
      this.field585 = var1.readUnsignedByte();
      this.field582 = var1.readUnsignedShort();
      this.field587 = var1.readUnsignedByte();
      this.field583 = var1.readUnsignedShort();
      this.field579 = var1.readUnsignedByte();
      this.field584 = var1.readUnsignedShort();
      this.field588 = var1.readUnsignedByte();
      this.method701();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-670897873"
   )
   void method701() {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "1"
   )
   static File method707(String var0) {
      if(!class160.field2179) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class160.field2180.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class160.field2181, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class160.field2180.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   static void method713() {
      if(class91.Login_isUsernameRemembered && class91.username != null && class91.username.length() > 0) {
         class91.field1347 = 1;
      } else {
         class91.field1347 = 0;
      }

   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lif;",
      garbageValue = "719502590"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class157.dat2File != null) {
         var4 = new IndexFile(var0, class157.dat2File, class157.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, class44.indexStore255, var0, var1, var2, var3);
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1949750364"
   )
   static final void method722(boolean var0) {
      if(var0) {
         Client.field908 = class91.field1367?class150.field2106:class150.field2108;
      } else {
         LinkedHashMap var1 = class222.preferences.preferences;
         String var3 = class91.username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field908 = var1.containsKey(Integer.valueOf(var5))?class150.field2111:class150.field2107;
      }

   }
}
