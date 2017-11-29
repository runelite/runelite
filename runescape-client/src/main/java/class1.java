import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class1 {
   @ObfuscatedName("nz")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static SpritePixels field12;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   static final class1 field0;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   static final class1 field1;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   static final class1 field2;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   static final class1 field4;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   static final class1 field5;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   static final class1 field7;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   static final class1 field6;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -1696751693
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1145018231
   )
   final int field3;

   static {
      field0 = new class1(5);
      field1 = new class1(3);
      field2 = new class1(0);
      field4 = new class1(2);
      field5 = new class1(6);
      field7 = new class1(1);
      field6 = new class1(4);
   }

   class1(int var1) {
      this.field3 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "378774994"
   )
   static File method2(String var0) {
      if(!class158.field2162) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class158.field2164.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class158.field2163, var0);
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
                  class158.field2164.put(var0, var2);
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Ljd;",
      garbageValue = "124"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "-841639778"
   )
   static void method1(GameEngine var0) {
      if(MouseInput.mouseLastButton == 1 || !Client.field956 && MouseInput.mouseLastButton == 4) {
         int var1 = class91.field1354 + 280;
         if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(0, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(0, 1);
            return;
         }

         int var2 = class91.field1354 + 390;
         if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(1, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(1, 1);
            return;
         }

         int var3 = class91.field1354 + 500;
         if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(2, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(2, 1);
            return;
         }

         int var4 = class91.field1354 + 610;
         if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(3, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            OwnWorldComparator.method1186(3, 1);
            return;
         }

         if(MouseInput.mouseLastPressedX >= class91.field1354 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class91.field1354 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
            class91.worldSelectShown = false;
            class182.field2511.method5266(class91.field1354, 0);
            class91.field1347.method5266(class91.field1354 + 382, 0);
            class91.logoSprite.method5245(class91.field1354 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class91.field1374 != -1) {
            World var5 = World.worldList[class91.field1374];
            class82.method1683(var5);
            class91.worldSelectShown = false;
            class182.field2511.method5266(class91.field1354, 0);
            class91.field1347.method5266(class91.field1354 + 382, 0);
            class91.logoSprite.method5245(class91.field1354 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-5"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3304 != 0 && var3 > IndexDataBase.field3304) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3304 != 0 && var6 > IndexDataBase.field3304) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class174.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }
}
