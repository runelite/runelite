import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class263 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field3475;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3473;
   @ObfuscatedName("i")
   @Export("offsetsY")
   public static int[] offsetsY;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   IterableHashTable field3474;

   static {
      field3473 = new NodeCache(64);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1859462717"
   )
   public void method4846() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-926795006"
   )
   public void method4863(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4848(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-729588203"
   )
   void method4848(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3474 = class255.readStringIntParameters(var1, this.field3474);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1322826731"
   )
   public int method4849(int var1, int var2) {
      return PendingSpawn.method1591(this.field3474, var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)Ljava/lang/String;",
      garbageValue = "255"
   )
   public String method4850(int var1, String var2) {
      return IndexData.method4604(this.field3474, var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1245708469"
   )
   static void method4867() {
      class62.field736 = 99;
      class62.field724 = new byte[4][104][104];
      class29.field403 = new byte[4][104][104];
      TotalQuantityComparator.field288 = new byte[4][104][104];
      class62.field725 = new byte[4][104][104];
      class21.field331 = new int[4][105][105];
      class160.field2156 = new byte[4][105][105];
      class62.field726 = new int[105][105];
      BoundingBox2D.field229 = new int[104];
      TotalQuantityComparator.field292 = new int[104];
      class62.field727 = new int[104];
      class94.field1417 = new int[104];
      BoundingBox3D.field247 = new int[104];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "1518838683"
   )
   static int method4861(int var0, Script var1, boolean var2) {
      Widget var3 = class216.getWidget(class80.intStack[--class80.intStackSize]);
      if(var0 == 2500) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class80.intStack[++class80.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class80.intStack[++class80.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class80.intStack[++class80.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class80.intStack[++class80.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class80.intStack[++class80.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1887170108"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1477527405"
   )
   static final void method4864() {
      if(Client.field943 > 0) {
         WorldMapType2.method516();
      } else {
         Client.field888.method5517();
         class87.setGameState(40);
         class160.field2161 = Client.field937.getSocket();
         Client.field937.method2047();
      }
   }
}
