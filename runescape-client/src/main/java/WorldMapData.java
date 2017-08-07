import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("nw")
   @ObfuscatedSignature(
      signature = "[Lbv;"
   )
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("g")
   String field455;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -138157675
   )
   int field459;
   @ObfuscatedName("d")
   boolean field456;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1384851047
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("n")
   String field454;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1751160917
   )
   int field463;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   Coordinates field458;
   @ObfuscatedName("o")
   LinkedList field464;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 970174489
   )
   int field460;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1705753331
   )
   int field462;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -204548981
   )
   int field457;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1795847647
   )
   int field453;

   public WorldMapData() {
      this.fileId = -1;
      this.field459 = -1;
      this.field463 = -1;
      this.field458 = null;
      this.field457 = Integer.MAX_VALUE;
      this.field460 = 0;
      this.field453 = Integer.MAX_VALUE;
      this.field462 = 0;
      this.field456 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "-547618543"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field454 = var1.readString();
      this.field455 = var1.readString();
      this.field458 = new Coordinates(var1.readInt());
      this.field459 = var1.readInt();
      var1.readUnsignedByte();
      this.field456 = var1.readUnsignedByte() == 1;
      this.field463 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field464 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field464.add(this.method344(var1));
      }

      this.method290();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1787597265"
   )
   public String method350() {
      return this.field454;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1295658241"
   )
   public boolean method283(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field457 && var3 <= this.field460) {
         if(var4 >= this.field453 && var4 <= this.field462) {
            Iterator var5 = this.field464.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod705(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1699662971"
   )
   public int method348() {
      return this.fileId;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "534034941"
   )
   public int[] method288(int var1, int var2, int var3) {
      Iterator var4 = this.field464.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod704(var1, var2, var3));

      return var5.vmethod706(var1, var2, var3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "53107116"
   )
   public int method297() {
      return this.field457;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "114"
   )
   public int method299() {
      return this.field453;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1145931292"
   )
   public boolean method286(int var1, int var2, int var3) {
      Iterator var4 = this.field464.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod704(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Lhq;",
      garbageValue = "-1363766937"
   )
   public Coordinates method289(int var1, int var2) {
      Iterator var3 = this.field464.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod705(var1, var2));

      return var4.vmethod728(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-543328133"
   )
   public int method302() {
      return this.field458.plane;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1107335064"
   )
   public int method301() {
      return this.field458.worldX;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "4"
   )
   public int method346() {
      return this.field458.worldY;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-784849164"
   )
   public int method296() {
      return this.field463;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1323854945"
   )
   void method290() {
      Iterator var1 = this.field464.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod703(this);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;I)Lam;",
      garbageValue = "182612095"
   )
   WorldMapSectionBase method344(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)GroundObject.forOrdinal(class27.method216(), var2);
      Object var4 = null;
      switch(var3.field397) {
      case 0:
         var4 = new class48();
         break;
      case 1:
         var4 = new WorldMapType3();
         break;
      case 2:
         var4 = new WorldMapType1();
         break;
      case 3:
         var4 = new WorldMapType2();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod716(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1251233249"
   )
   public boolean method292() {
      return this.field456;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "30699"
   )
   public int method298() {
      return this.field460;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method345() {
      return this.field462;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1698552475"
   )
   int method295() {
      return this.field459;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-67"
   )
   public String method294() {
      return this.field455;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Lhq;",
      garbageValue = "82"
   )
   public Coordinates method311() {
      return new Coordinates(this.field458);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "646967615"
   )
   static boolean method332(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-4381029"
   )
   static void method342(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class24.method183(var1, var2);
      if(var5 != null) {
         if(var5.field2723 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field839 = var0;
            var6.field840 = var4;
            var6.field849 = var5.field2723;
            PendingSpawn.method1525(var6);
         }

         boolean var7 = true;
         if(var5.contentType > 0) {
            var7 = class36.method498(var5);
         }

         if(var7) {
            if(Signlink.method2963(class15.getWidgetConfig(var5), var0 - 1)) {
               if(var0 == 1) {
                  Client.secretPacketBuffer1.putOpcode(71);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 2) {
                  Client.secretPacketBuffer1.putOpcode(42);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 3) {
                  Client.secretPacketBuffer1.putOpcode(190);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 4) {
                  Client.secretPacketBuffer1.putOpcode(95);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 5) {
                  Client.secretPacketBuffer1.putOpcode(73);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 6) {
                  Client.secretPacketBuffer1.putOpcode(184);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 7) {
                  Client.secretPacketBuffer1.putOpcode(67);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 8) {
                  Client.secretPacketBuffer1.putOpcode(127);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 9) {
                  Client.secretPacketBuffer1.putOpcode(197);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 10) {
                  Client.secretPacketBuffer1.putOpcode(155);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

            }
         }
      }
   }
}
