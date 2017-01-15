import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class97 implements class158 {
   @ObfuscatedName("u")
   public static final class97 field1619 = new class97(1, 0);
   @ObfuscatedName("i")
   public static final class97 field1620 = new class97(2, 2);
   @ObfuscatedName("cx")
   static class208 field1621;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1367917779
   )
   public final int field1622;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1147706147
   )
   final int field1623;
   @ObfuscatedName("a")
   public static final class97 field1624 = new class97(0, 3);
   @ObfuscatedName("x")
   public static final class97 field1625 = new class97(3, 1);
   @ObfuscatedName("ef")
   static ModIcon[] field1626;
   @ObfuscatedName("b")
   static int[] field1627;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "723314664"
   )
   public static CombatInfo2 method1874(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2815.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2821.method3272(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method3515(new Buffer(var2));
         }

         CombatInfo2.field2815.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod4062() {
      return this.field1623;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1622 = var1;
      this.field1623 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1713265301"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(Friend.worldServersDownload == null) {
            Friend.worldServersDownload = new class26(class44.field881, new URL(class15.field170));
         } else {
            byte[] var0 = Friend.worldServersDownload.method595();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field684 = var1.readUnsignedShort();
               World.worldList = new World[World.field684];

               World var2;
               for(int var3 = 0; var3 < World.field684; var2.index = var3++) {
                  var2 = World.worldList[var3] = new World();
                  var2.id = var1.readUnsignedShort();
                  var2.mask = var1.method2780();
                  var2.address = var1.method2965();
                  var2.activity = var1.method2965();
                  var2.location = var1.readUnsignedByte();
                  var2.playerCount = var1.method2968();
               }

               VertexNormal.method1597(World.worldList, 0, World.worldList.length - 1, World.field674, World.field676);
               Friend.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         Friend.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass178;",
      garbageValue = "805146703"
   )
   public static class178 method1877(int var0) {
      class178[] var1 = class11.method154();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class178 var3 = var1[var2];
         if(var3.field2652 == var0) {
            return var3;
         }
      }

      return null;
   }
}
